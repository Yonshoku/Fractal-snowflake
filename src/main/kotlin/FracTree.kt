import java.awt.Graphics

class FracTree (x: Double, y: Double, var r: Double, var levelsNum: Int) {
    var factor: Double = 2.4
    var initNode = Node(this, 1, x, y, r)


    fun draw(canvas: Canvas, graphics: Graphics?) {
        initNode.draw(canvas, graphics)
    }

    fun paintTree(canvas2: Canvas2, graphics: Graphics?) {
        initNode.paintTree(canvas2, graphics, 0, 900, 20)
    }
}