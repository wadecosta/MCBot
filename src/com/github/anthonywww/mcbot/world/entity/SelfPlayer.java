package com.github.anthonywww.mcbot.world.entity;

import java.net.ConnectException;
import java.net.Proxy;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.joml.Math;
import org.joml.Vector3d;

import com.github.anthonywww.mcbot.MCBot;
import com.github.anthonywww.mcbot.Terminal;
import com.github.anthonywww.mcbot.cli.AnsiColor;
import com.github.anthonywww.mcbot.cli.ICLICommand;
import com.github.steveice10.mc.auth.exception.request.InvalidCredentialsException;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.protocol.MinecraftConstants;
import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.mc.protocol.data.SubProtocol;
import com.github.steveice10.mc.protocol.data.game.ClientRequest;
import com.github.steveice10.mc.protocol.data.game.entity.player.GameMode;
import com.github.steveice10.mc.protocol.data.message.Message;
import com.github.steveice10.mc.protocol.data.message.TranslationMessage;
import com.github.steveice10.mc.protocol.data.status.ServerStatusInfo;
import com.github.steveice10.mc.protocol.data.status.handler.ServerInfoHandler;
import com.github.steveice10.mc.protocol.data.status.handler.ServerPingTimeHandler;
import com.github.steveice10.mc.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.client.ClientRequestPacket;
import com.github.steveice10.mc.protocol.packet.ingame.client.player.ClientPlayerAbilitiesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.client.player.ClientPlayerPositionRotationPacket;
import com.github.steveice10.mc.protocol.packet.ingame.client.player.ClientPlayerRotationPacket;
import com.github.steveice10.mc.protocol.packet.ingame.client.world.ClientTeleportConfirmPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerJoinGamePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.player.ServerPlayerAbilitiesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.player.ServerPlayerHealthPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.player.ServerPlayerPositionRotationPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerSpawnPositionPacket;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.DisconnectedEvent;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.event.session.SessionAdapter;
import com.github.steveice10.packetlib.tcp.TcpSessionFactory;

public class SelfPlayer extends Player {

	private static final Logger logger = Logger.getLogger("");
	private Client client;

	public SelfPlayer(String username) {
		super(username);
	}

	public final boolean isConnected() {
		if (client != null) {
			if (client.getSession() != null) {
				return client.getSession().isConnected();
			}
		}
		return false;
	}

	public final synchronized void connect(String address, int port, Proxy proxy, String username, String password) throws ConnectException {

		if (client != null) {
			if (client.getSession() != null) {
				if (client.getSession().isConnected()) {
					MCBot.getInstance().log(Level.WARNING, "Already connected!");
					return;
				}
			}
		}

		// Ping server first
		pingServer(address, port, proxy);

		// Attempt to authenticate with mojang
		final MinecraftProtocol protocol;
		
		if (!password.isEmpty()) {
			try {
				protocol = new MinecraftProtocol(username, password);
				MCBot.getInstance().log(Level.INFO, Terminal.colorize(AnsiColor.GREEN + "Successfully authenticated: " + AnsiColor.AQUA + username + AnsiColor.RESET));
			} catch (InvalidCredentialsException e) {
				MCBot.getInstance().log(Level.WARNING, "Invalid password!");
				return;
			} catch (RequestException e) {
				MCBot.getInstance().getTerminal().handleException(e);
				return;
			}
		} else {
			protocol = new MinecraftProtocol(username);
		}

		MCBot.getInstance().log(Level.INFO, "Connecting to " + address + ":" + port + " ...");
		client = new Client(address, port, protocol, new TcpSessionFactory(proxy));
		client.getSession().setFlag(MinecraftConstants.AUTH_PROXY_KEY, proxy);
		client.getSession().addListener(new ClientSessionAdapter());
		client.getSession().connect(true);
	}

	public final synchronized void disconnect() {
		if (client.getSession().isConnected()) {
			client.getSession().disconnect("Finished");
		}
	}

	public void sendMessage(String message) {
		if (client != null) {
			if (client.getSession() != null) {
				if (client.getSession().isConnected()) {
					client.getSession().send(new ClientChatPacket(message));
				} else {
					MCBot.getInstance().log(Level.WARNING, "Not connected to a server!");
				}
			}
		}
	}

	public void sendRotate(float yaw, float pitch) {
		if (client != null) {
			if (client.getSession() != null) {
				if (client.getSession().isConnected()) {

					setYaw(yaw);
					setPitch(pitch);

					client.getSession().send(new ClientPlayerRotationPacket(isOnGround(), getYaw(), getPitch()));
				} else {
					MCBot.getInstance().log(Level.WARNING, "Not connected to a server!");
				}
			}
		}
	}
	
	public void centerPosition() {
		final double dx = getX() > 0 ? Math.floor(getX()) + 0.5d : Math.round(getX()) - 0.5d;
		final double dy = Math.floor(getY());
		final double dz = getZ() > 0 ? Math.floor(getZ()) + 0.5d : Math.round(getZ()) - 0.5d;
		
		setX(dx);
		setY(dy);
		setZ(dz);
		
		client.getSession().send(new ClientPlayerPositionRotationPacket(isOnGround(), getX(), getY(), getZ(), getYaw(), getPitch()));
	}
	
	private Vector3d getUnitVector(double angleYaw, double anglePitch) {
		final double dx = -Math.cos(anglePitch) * Math.sin(angleYaw);
		final double dy = -Math.sin(anglePitch);
		final double dz = Math.cos(anglePitch) * Math.cos(angleYaw);
		
		return new Vector3d(dx, dy, dz);
	}
	
	public void moveForward(double distance) {
		final Vector3d vec = getUnitVector(Math.toRadians(getYaw()), Math.toRadians(getPitch()));
		move(vec.x*distance, vec.y*distance, vec.z*distance);
	}
	
	public void moveBackward(double distance) {
		moveForward(-distance);
	}
	
	public void moveLeft(double distance) {
		// FIXME: Wrap the yaw-angle 90 degrees and use the same trig functions to find the unit vector
		double yaw = getYaw();
		
		if (yaw+90 > 180) {
			double error = (180 - yaw+90);
			yaw = -180 - error;
		} else {
			yaw = yaw + 90;
		}
		
		final Vector3d vec = getUnitVector(Math.toRadians(yaw), Math.toRadians(getPitch()));
		move(vec.x*distance, vec.y*distance, vec.z*distance);
	}
	
	public void moveRight(double distance) {
		moveLeft(-distance);
	}
	
	public void move(double dx, double dy, double dz) {
		centerPosition();

		int steps = (int) ((int) 2.0 * Math.floor(Math.sqrt(java.lang.Math.pow(dx, 2) + java.lang.Math.pow(dy, 2) + java.lang.Math.pow(dz, 2))));
		double sx = dx / steps;
		double sy = dy / steps;
		double sz = dz / steps;
		
		for (int i=0; i<steps; i++) {
			setX(getX() + sx);// + (Math.random()/10000));
			setY(getY() + sy);
			setZ(getZ() + sz);// + (Math.random()/10000));

			logger.finest("moving " + isOnGround() + " " + getX() + ", " + getY() + ", " + getZ() + " yaw=" + getYaw() + " pitch=" + getPitch());
			client.getSession().send(new ClientPlayerPositionRotationPacket(isOnGround(), getX(), getY(), getZ(), getYaw(), getPitch()));

			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {}
		}
	}

	public static final void pingServer(String address, int port, Proxy proxy) {
		MinecraftProtocol protocol = new MinecraftProtocol(SubProtocol.STATUS);
		Client statusClient = new Client(address, port, protocol, new TcpSessionFactory(proxy));

		statusClient.getSession().setFlag(MinecraftConstants.AUTH_PROXY_KEY, proxy);
		
		statusClient.getSession().setFlag(MinecraftConstants.SERVER_INFO_HANDLER_KEY, new ServerInfoHandler() {
			@Override
			public void handle(Session session, ServerStatusInfo info) {
				MCBot.getInstance().log(Level.INFO, "Server Version: " + info.getVersionInfo().getVersionName() + ", " + info.getVersionInfo().getProtocolVersion());
				MCBot.getInstance().log(Level.INFO, "Player Count: " + info.getPlayerInfo().getOnlinePlayers() + " / " + info.getPlayerInfo().getMaxPlayers());
				MCBot.getInstance().log(Level.FINER, "Players: " + Arrays.toString(info.getPlayerInfo().getPlayers()));
				MCBot.getInstance().log(Level.FINER, "Description: " + info.getDescription().getFullText());
				MCBot.getInstance().log(Level.FINER, "Icon: " + info.getIcon());
			}
		});
		
		statusClient.getSession().setFlag(MinecraftConstants.SERVER_PING_TIME_HANDLER_KEY, new ServerPingTimeHandler() {
			@Override
			public void handle(Session session, long pingTime) {
				MCBot.getInstance().log(Level.INFO, "Response in: " + pingTime + "ms.");
			}
		});

		statusClient.getSession().setConnectTimeout(3);
		statusClient.getSession().connect(true);

		while (statusClient.getSession().isConnected()) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				MCBot.getInstance().getTerminal().handleException(e);
			}
		}
	}

	private class ClientSessionAdapter extends SessionAdapter {

		protected ClientSessionAdapter() {

		}

		@Override
		public void packetReceived(PacketReceivedEvent event) {

			// On join server
			if (event.getPacket() instanceof ServerJoinGamePacket) {
				ServerJoinGamePacket packet = (ServerJoinGamePacket) event.getPacket();

				setId(packet.getEntityId());
				setGamemode(packet.getGameMode());
				setOnGround(true);

				// TODO: add features
				packet.getWorldType();
				packet.getDifficulty();
				packet.getDimension();
				packet.getHardcore();

				MCBot.getInstance().log(Level.INFO, Terminal.colorize(AnsiColor.GREEN + "Successfully connected to server." + AnsiColor.RESET));

				final String joinMessage = MCBot.getInstance().getConfig().getJoinMessage();
				MCBot.getInstance().log(Level.INFO, "Sending join message: " + joinMessage);
				event.getSession().send(new ClientChatPacket(joinMessage));
			}

			// Server Player Abilities
			else if (event.getPacket() instanceof ServerPlayerAbilitiesPacket) {
				ServerPlayerAbilitiesPacket packet = (ServerPlayerAbilitiesPacket) event.getPacket();

				setInvincible(packet.getInvincible());
				setCanFly(packet.getCanFly());
				setGamemode((packet.getCreative() ? GameMode.CREATIVE : GameMode.SURVIVAL));
				setFlySpeed(packet.getFlySpeed());
				setWalkSpeed(packet.getWalkSpeed());

				event.getSession().send(new ClientPlayerAbilitiesPacket(isInvincible(), getCanFly(), !isOnGround(), (getGamemode() == GameMode.CREATIVE ? true : false), getFlySpeed(), getWalkSpeed()));
			}

			// Server Player Position Rotation
			else if (event.getPacket() instanceof ServerPlayerPositionRotationPacket) {
				ServerPlayerPositionRotationPacket packet = (ServerPlayerPositionRotationPacket) event.getPacket();

				setX(packet.getX());
				setY(packet.getY());
				setZ(packet.getZ());
				setYaw(packet.getYaw());
				setPitch(packet.getPitch());
				
				MCBot.getInstance().log(Level.INFO, "got new position: " + getX() + ", " + getY() + ", " + getZ() + " (tpid:" + packet.getTeleportId() + ") yaw=" + getYaw() + " pitch=" + getPitch());
				event.getSession().send(new ClientTeleportConfirmPacket(packet.getTeleportId()));
				event.getSession().send(new ClientPlayerPositionRotationPacket(isOnGround(), getX(), getY(), getZ(), getYaw(), getPitch()));
			}

			// Update health record
			else if (event.getPacket() instanceof ServerPlayerHealthPacket) {
				ServerPlayerHealthPacket health = (ServerPlayerHealthPacket) event.getPacket();

				MCBot.getInstance().log(Level.INFO, "[health] Hearts: " + health.getHealth() + " Food: " + health.getFood());

				if (health.getFood() <= 4) {
					event.getSession().send(new ClientChatPacket("I'm hungry"));
				}

				if (health.getHealth() < getHealth()) {
					if (health.getHealth() < 6.0F) {
						event.getSession().send(new ClientChatPacket("I have critical health!"));

						if (health.getHealth() == 0.0F) {
							System.out.println("[DEATH] I died at " + getPosition());

							try {
								Thread.sleep(1000L);
							} catch (InterruptedException e) {

							}
							event.getSession().send(new ClientRequestPacket(ClientRequest.RESPAWN));
						}

					} else {

						final String[] messages = new String[] {
							"Ouch!", "Ow!",
							"Hey!", "That hurts!",
							"That's not nice!"
						};

						final int i = new Random().nextInt(messages.length);
						event.getSession().send(new ClientChatPacket(messages[i]));
					}
				}

				setHealth(health.getHealth());
				setFood(health.getFood());
			}

			// Spawn position
			else if (event.getPacket() instanceof ServerSpawnPositionPacket) {
				ServerSpawnPositionPacket packet = (ServerSpawnPositionPacket) event.getPacket();
				setX(packet.getPosition().getX());
				setY(packet.getPosition().getY());
				setZ(packet.getPosition().getZ());

				// event.getSession().send(new ClientPlayerPositionPacket(bot.isOnGround(),
				// bot.getX(), bot.getY(), bot.getZ()));
			}

			// Chat message
			else if (event.getPacket() instanceof ServerChatPacket) {
				Message message = ((ServerChatPacket) event.getPacket()).getMessage();
				
				MCBot.getInstance().log(Level.INFO, "[chat] " + message.getFullText());

				if (message instanceof TranslationMessage) {
					MCBot.getInstance().log(Level.FINEST, "Received Translation Components: " + Arrays.toString(((TranslationMessage) message).getTranslationParams()));
				}
				
				String rawMessage = message.getFullText();
				String username = null;
				String text = "";
				String textParts[] = rawMessage.split(" ");
				
				// Parse username from message (VANILLA)
				if (textParts[0].startsWith("<") && textParts[0].endsWith(">")) {
					username = textParts[0].substring(1, textParts[0].length()-1);
				}
				
				for (int i=1; i<textParts.length; i++) {
					text += textParts[i];
					if (i != textParts.length-1) {
						text += " ";
					}
				}
				
				text = text.trim();
				
				// Call chat callback method in lua sandbox
				MCBot.getInstance().getLua().getLuaBot().rawChatCallback(text);
				MCBot.getInstance().getLua().getLuaBot().chatCallback(username, text);
				
				// Built in commands
				for (String friend : MCBot.getInstance().getConfig().getFriends()) {
					if (username != null && username.equalsIgnoreCase(friend) && !username.equals(MCBot.getInstance().getConfig().getUsername())) {
						if (text.startsWith("!")) {
							for (ICLICommand command : MCBot.getInstance().getTerminal().getRegisteredCommands()) {
								String[] texts = text.split(Pattern.quote(" "));
								String textCmd = texts[0].substring(1);
								String textArgs[] = Arrays.copyOfRange(texts, 1, texts.length);
								System.out.println(textCmd);
								if (command.commandName().equalsIgnoreCase(textCmd)) {
									command.invoke(textArgs);
									break;
								}
							}
						}
					}
				}
				
			}
		}

		@Override
		public void disconnected(DisconnectedEvent event) {
			MCBot.getInstance().log(Level.FINER, "Disconnected: " + Message.fromString(event.getReason()).getFullText());

			if (event.getCause() != null) {

				if (event.getCause() instanceof ConnectException) {
					MCBot.getInstance().log(Level.WARNING, "Failed to connect to server! (" + event.getCause().getMessage() + ")");
					// MCBot.getInstance().shutdown();
					return;
				}

				MCBot.getInstance().log(Level.WARNING, "Error while connected: " + event.getReason());
				MCBot.getInstance().getTerminal().handleException(event.getCause());
			} else {
				MCBot.getInstance().log(Level.INFO, "Disconnected from server: " + Message.fromString(event.getReason()).getText());
			}
		}
	}
	
	
}