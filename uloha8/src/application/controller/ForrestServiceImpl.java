package application.controller;

import application.controller.scenicscoreservice.ScenicServiceImpl;
import application.controller.visionservice.VisionServiceImpl;
import application.model.Forrest;

/**
 * Implementation of the Forrest service interface
 *
 * @author Adam Repka
 */
public class ForrestServiceImpl implements ForrestServiceInt {

    private final VisionServiceImpl visionService;
    private final ScenicServiceImpl scenicService;

    public ForrestServiceImpl(Forrest forrest) {
        visionService = new VisionServiceImpl(forrest);
        scenicService = new ScenicServiceImpl(forrest);
    }

    @Override
    public int getVisibleTrees() {
        return visionService.getVisibleTrees();
    }

    @Override
    public int getHighestScenicScore() {
        return scenicService.getHighestScenicScore();
    }
}
