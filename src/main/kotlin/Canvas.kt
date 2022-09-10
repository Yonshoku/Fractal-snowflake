import java.awt.*
import javax.swing.JPanel

class Canvas(private val mWidth: Int, private val mHeight: Int): JPanel() {
    private val max: Double = 900.0

    var canvasColor: Color = Color(255, 255, 255)
    var contourColor: Color = Color(0, 0, 0)
    var shapeColor: Color = Color(0, 0, 0)
    var fracTree: FracTree = FracTree(0.0, 0.0, 250.0, 1)
    var canvas2: Canvas2? = null

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

        fracTree.draw(this, g)
    }

    fun updateLevels(num: Int) {
        fracTree = FracTree(0.0, 0.0, 250.0 - num * 10, num)
        canvas2!!.updateLevels(fracTree)
        repaint()
    }

    fun convertX(x: Double): Int {
        return (((x + max) / (max * 2)) * mWidth).toInt()
    }

    fun convertY(y: Double): Int {
        return (mHeight - ((y + max) / (max * 2)) * mHeight).toInt()
    }

    fun convertDistance(dist: Double): Int {
        return ((mWidth / (max * 2)) * dist).toInt()
    }
}