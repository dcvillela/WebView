package edu.fema.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class MyPhaseListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent phase) {
		// System.out.println("MyPhaseListener.afterPhase() "+phase.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent phase) {
		// System.out.println("MyPhaseListener.beforePhase() "+phase.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}