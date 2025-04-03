package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexDriver implements Job2dDriver {
    private final List<Job2dDriver> children = new ArrayList<>();

    public void add(Job2dDriver driver){
        children.add(driver);
    }

    public void remove(Job2dDriver driver){
        children.remove(driver);
    }

    @Override
    public void setPosition(int i, int i1) {
        for(Job2dDriver child : children){
            child.setPosition(i, i1);
        }
    }

    @Override
    public void operateTo(int i, int i1) {
        for(Job2dDriver child : children){
            child.operateTo(i, i1);
        }
    }
}
