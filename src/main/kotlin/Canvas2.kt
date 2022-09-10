import java.awt.*
import javax.swing.JPanel

class Canvas2(private val mWidth: Int, private val mHeight: Int): JPanel() {
    private val max: Double = 10.0

    var canvasColor: Color = Color(255, 255, 255)
    var contourColor: Color = Color(0, 0, 0)
    var shapeColor: Color = Color(0, 0, 0)
    var fracTree: FracTree? = FracTree(0.0, 0.0, 100.0, 1)

    init {
        preferredSize = Dimension(mWidth, mHeight)
        minimumSize = Dimension(mWidth, mHeight)
        maximumSize = Dimension(mWidth, mHeight)
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        background = canvasColor

        (g as Graphics2D).color = contourColor
        g.stroke = BasicStroke(1f)
        g.color = shapeColor

        fracTree!!.paintTree(this, g)
    }

    fun updateLevels(tree: FracTree) {
        fracTree = tree
        repaint()
    }
}