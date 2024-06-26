package com.corejava.official.v2ch08.rect;

import com.corejava.official.v2ch08.sourceAnnotations.ToString;

@ToString(includeName=false)
public class Point {
    private int x;
    private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @ToString(includeName=false) public int getX() { return x; }
    @ToString(includeName=false) public int getY() { return y; }
}
