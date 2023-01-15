package es.ucm.fdi.ici.c2122.practica2.grupo05.mspacman.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.TreeMap;

import es.ucm.fdi.ici.Action;
import es.ucm.fdi.ici.c2122.practica2.grupo05.EnumMultiset;
import es.ucm.fdi.ici.c2122.practica2.grupo05.GameUtils;
import es.ucm.fdi.ici.c2122.practica2.grupo05.NearestEdibleGhostInformation;
import pacman.controllers.GhostController;
import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class NoGoodMovesChaseGhostAction implements Action {

	private int limitForChasingGhost = 65;
	public NoGoodMovesChaseGhostAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MOVE execute(Game game) {
		int mspacman = game.getPacmanCurrentNodeIndex();
		if(game.isJunction(mspacman)) {
		
				
			Map<MOVE, Double> map = new HashMap<>();
			GameUtils.getBestRunAwayGhost(game, limitForChasingGhost, map);
			TreeMap<MOVE, Double> sorted = new TreeMap<>(Collections.reverseOrder());
			sorted.putAll(map);
	
		
			return sorted.firstKey();
		}
		return MOVE.NEUTRAL;
	}

	@Override
	public String getActionId() {
		return "Chase Edible Ghost Action";
	}

}