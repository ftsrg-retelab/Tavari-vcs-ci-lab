package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import java.util.Timer;
import java.util.TimerTask;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private Timer timer;
	private TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				controller.followSpeed();
			}
		};

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(timerTask,1000,1000);
	}

	@Override
	public boolean getAlarmFlag() {
		return false;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		controller.setJoystickPosition(joystickPosition);
	}

}
