/**
 * Description:
 * Author: XM
 * Date: 2024-02-12
 */
package com.osxm.je.chp5.vscode;

import java.util.Arrays;
import java.util.List;

public class Refactor {

    private static final double _3_14 = 3.14;

    public double getAreaAfter(double r) {
        return _3_14 * r * r;
    }

    public Refactor(String id, String name) {

    }

    public void assignToVar() {
        List<String> asList = Arrays.asList("Liu", "Guan", "Zhang");
    }

    public double getArea(double r) {
        return 3.14 * r * r;
    }

    public void extractFieldBefore() {
        int height = 1;
        int width = 2;
        int area = height * width;
    }

    private int area;

    public void extractFieldAfter() {
        int height = 1;
        int width = 2;
        area = height * width;
    }

    public void extractMethodBefore() {
        int height = 1;
        int width = 2;
        int area = height * width;
    }

    public void extractMethodAfter() {
        int height = 1;
        int width = 2;
        int area = height * width;
    }

    public void extraLocalVarBefore(String fruit) {
        if ("Apple".equals(fruit)) {
            //
        }
    }

    public void extraLocalVarAfter(String fruit) {
        boolean equals = "Apple".equals(fruit);
        if (equals) {
            //
        }
    }

    public void inlineLocalVarBefore(String fruit) {
        boolean equals = "Apple".equals(fruit);
        if (equals) {
            //
        }
    }

    public void inlineLocalVarAfter(String fruit) {
        if ("Apple".equals(fruit)) {
            //
        }
    }

    private static final double PI = 3.14;

    public double inlineConstantBefore(double r) {
        return PI * r * r;
    }

    public double inlineConstantAfter(double r) {
        return 3.14 * r * r;
    }

    public void inlineMethodBefore() {
        int height = 1;
        int width = 2;
        int area = getArea(height, width);
    }

    private int getArea(int height, int width) {
        return height * width;
    }

    public void inlineMethodAfter() {
        int height = 1;
        int width = 2;
        int area = height * width;
    }

    public void invertCondBefore(int value) {
        if (value > 1 && value < 3) {

        }
    }

    public void invertCondAfter(int value) {
        if (value <= 1 || value >= 3) {

        }
    }

    public void invertLocalVarBefore(int value) {
        boolean valid = value > 1 && value < 3;
    }

    public void invertLocalVarAfter(int value) {
        boolean notValid = value <= 1 || value >= 3;
    }

    

}
