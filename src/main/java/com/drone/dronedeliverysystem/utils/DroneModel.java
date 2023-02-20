package com.drone.dronedeliverysystem.utils;

public enum DroneModel {

    Lightweight("Lightweight"),
    Middleweight("Middleweight"),
    Cruiserweight("Cruiserweight"),
    Heavyweight("Heavyweight");

    private final String droneModelName;

    DroneModel(String modelName) {
        this.droneModelName = modelName;
    }

    public String getDroneModel() {
        return droneModelName;
    }
}
