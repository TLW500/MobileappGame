package com.example.lab3sensors

// PlayerDot.kt
class PlayerDot(private var x: Float, private var y: Float, private val radius: Float) {

    fun move(dx: Float, dy: Float) {
        // Add logic to move the player dot based on accelerometer readings
        // You can adjust the position limits if needed
        x += dx
        y += dy
    }

    fun getX(): Float {
        return x
    }

    fun getY(): Float {
        return y
    }

    fun getRadius(): Float {
        return radius
    }
}

