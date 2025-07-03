package com.example.lab3sensors

// GameView.kt
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlin.concurrent.fixedRateTimer

class GameView(context: Context, attrs: AttributeSet) : SurfaceView(context, attrs), SurfaceHolder.Callback {

    private var playerDot: PlayerDot
    private var movingDot: MovingDot

    private val playerPaint = Paint().apply {
        color = Color.BLUE
        isAntiAlias = true
    }

    private val movingDotPaint = Paint().apply {
        color = Color.RED
        isAntiAlias = true
    }

    init {
        holder.addCallback(this)
        playerDot = PlayerDot(0f, 0f, 30f) // Initialize player dot with desired parameters
        movingDot = MovingDot(context.resources.displayMetrics.widthPixels / 2f,
            context.resources.displayMetrics.heightPixels / 2f,
            20f) // Initialize moving dot at the center of the screen
    }

    fun movePlayer(x: Float, y: Float) {
        playerDot.move(x, y)
        // Add logic for moving playerDot and collision detection
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        fixedRateTimer("gameLoop", false, 0L, 16) {
            val canvas = holder.lockCanvas()
            canvas?.let {
                draw(canvas)
                holder.unlockCanvasAndPost(canvas)
            }
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        // Handle surface changes, if needed
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        // Stop the game loop
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        // Clear the canvas
        canvas.drawColor(Color.WHITE)

        // Draw player dot
        canvas.drawCircle(playerDot.getX(), playerDot.getY(), playerDot.getRadius(), playerPaint)

        // Draw moving dot
        canvas.drawCircle(movingDot.getX(), movingDot.getY(), movingDot.getRadius(), movingDotPaint)

        // Add additional drawing logic as needed
    }
}




