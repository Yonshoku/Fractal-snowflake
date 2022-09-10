import java.awt.BorderLayout
import java.awt.Color
import java.awt.Component
import java.awt.FlowLayout
import java.awt.event.ActionListener
import javax.swing.*

class MFrame2(): JFrame() {
    private val frameWidth = 900
    private val frameHeight = 900
    private val canvasWidth = 900
    private val canvasHeight = 900

    val canvas = Canvas2(canvasWidth, canvasHeight)
    private val canvasBox = Box(BoxLayout.Y_AXIS)

    private val buttonsPanel = JPanel(FlowLayout(FlowLayout.CENTER))
    init {
        initFrame()

        // Frame
        contentPane.layout = BorderLayout()

        // Canvas
        canvasBox.add(Box.createVerticalGlue())
        canvasBox.add(canvas)
        canvasBox.add(Box.createVerticalGlue())

        contentPane.add(canvasBox, BorderLayout.PAGE_START)
        contentPane.add(buttonsPanel, BorderLayout.PAGE_END)

        isResizable = false
        isVisible = true
    }

    fun initFrame() {
        title = "Tree"
        setSize(frameWidth, frameHeight)

        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
    }
}