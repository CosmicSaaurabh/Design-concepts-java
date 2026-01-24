package com.saurabh.implementation1;

public class Vehicle {
    private String vehicleNo;
    private VehicleType vehicleType;

    Vehicle(String VehicleNo, VehicleType vehicleType) {
        this.vehicleNo = VehicleNo;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
}
