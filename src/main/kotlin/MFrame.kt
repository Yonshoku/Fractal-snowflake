import java.awt.BorderLayout
import java.awt.Color
import java.awt.Component
import java.awt.FlowLayout
import java.awt.event.ActionListener
import javax.swing.*

class MFrame: JFrame() {
    private val frameWidth = 1050
    private val frameHeight = 1050
    private val canvasWidth = 900
    private val canvasHeight = 900

    private val canvas = Canvas(canvasWidth, canvasHeight)
    private val canvasBox = Box(BoxLayout.Y_AXIS)

    private val variants = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    private val comboBox = JComboBox(variants)

    private val buttonsPanel = JPanel(FlowLayout(FlowLayout.CENTER))
    init {
        initFrame()

        // Frame
        contentPane.layout = BorderLayout()

        // Canvas
        canvasBox.add(Box.createVerticalGlue())
        canvasBox.add(canvas)
        canvasBox.add(Box.createVerticalGlue())
        buttonsPanel.add(comboBox)

        contentPane.add(canvasBox, BorderLayout.PAGE_START)
        contentPane.add(buttonsPanel, BorderLayout.PAGE_END)

        comboBox.addActionListener { e ->
            var item = (e.source as JComboBox<*>).selectedItem as String

            when (item) {
                "1" -> canvas.updateLevels(1)
                "2" -> canvas.updateLevels(2)
                "3" -> canvas.updateLevels(3)
                "4" -> canvas.updateLevels(4)
                "5" -> canvas.updateLevels(5)
                "6" -> canvas.updateLevels(6)
                "7" -> canvas.updateLevels(7)
                "8" -> canvas.updateLevels(8)
                "9" -> canvas.updateLevels(9)
                "10" -> canvas.updateLevels(10)
            }
        }

        isResizable = false
        isVisible = true

        canvas.canvas2 = MFrame2().canvas
    }

    fun initFrame() {
        title = "Fractal"
        setSize(frameWidth, frameHeight)

        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
    }
}