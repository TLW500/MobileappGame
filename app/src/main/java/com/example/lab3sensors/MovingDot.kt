package com.example.lab3sensors

// MovingDot.kt
class MovingDot(private var x: Float, private var y: Float, private val radius: Float) {

    // Add logic to update the position of the moving dot
    // This can be done in the game loop or using a separate thread

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

