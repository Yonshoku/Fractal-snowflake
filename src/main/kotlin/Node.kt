import java.awt.Color
import java.awt.Graphics

class Node(var tree: FracTree, var level: Int, var centerX: Double, var centerY: Double, var r: Double) {
    var gap: Double = 0.0
    var children: MutableList<Node> = mutableListOf()
    var childrenCoords: MutableList<Point> = mutableListOf()
    var levelsGap: Int = 50

    init {
        calculateGap()
        calcChildren()
    }

    private fun calculateGap() {
        var rn: Double = 0.0

        for (i in 0 until tree.levelsNum - level - 1) {
            rn = tree.r / Math.pow(tree.factor, (level + 1 + i).toDouble())
            gap += 2.0 * rn * Math.pow(tree.factor, i.toDouble())
        }
    }

    private fun calcChildren() {
        var childR: Double = r / tree.factor
        if (level < tree.levelsNum) {
            // Calculate coords
            childrenCoords.add(Point(centerX, centerY + r + gap + childR))
            childrenCoords.add(Point(centerX + (r + gap + childR) * Math.cos(Math.PI / 6), centerY + (r + gap + childR) * Math.sin(Math.PI / 6)))
            childrenCoords.add(Point(centerX + (r + gap + childR) * Math.cos(-Math.PI / 6), centerY + (r + gap + childR) * Math.sin(-Math.PI / 6)))
            childrenCoords.add(Point(centerX, centerY - r - gap - childR))
            childrenCoords.add(Point(centerX + (r + gap + childR) * Math.cos(-5 * Math.PI / 6), centerY + (r + gap + childR) * Math.sin(-5 * Math.PI / 6)))
            childrenCoords.add(Point(centerX + (r + gap + childR) * Math.cos(5 * Math.PI / 6), centerY + (r + gap + childR) * Math.sin(5 * Math.PI / 6)))

            // Init children
            for (i in 0 until 6) {
                children.add(Node(tree, level + 1, childrenCoords[i].x, childrenCoords[i].y, childR))
            }

            for (i in 0 until 6) {
                println("${childrenCoords[i].x}, ${childrenCoords[i].y}, $childR, $gap")
            }
        }
    }

    fun draw(canvas: Canvas, g: Graphics?) {
        g!!.drawOval(canvas.convertX(centerX) - canvas.convertDistance(r),
            canvas.convertY(centerY) - canvas.convertDistance(r),
            2 * canvas.convertDistance(r),
            2 * canvas.convertDistance(r))
        println("draw: ${canvas.convertX(centerX)}, ${canvas.convertY(centerY)}, ${canvas.convertDistance(r)}")

        if (level < tree.levelsNum)
            for (i in 0 until 6)
                children[i].draw(canvas, g)
    }

    fun paintTree(canvas2: Canvas2, g: Graphics?, startX: Int, finishX: Int, startY: Int) {
        // Exit if it's last level
        if (level >= tree.levelsNum)
            return

        // Draw lines to children
        for (i in 0 until 6) {
            g!!.drawLine(startX + (finishX - startX) / 2, startY, startX + ((finishX - startX) / 6) * i + (finishX - startX) / 12, startY + levelsGap)
        }

        // Set intervals to children
        for (i in 0 until 6) {
            children[i].paintTree(canvas2, g, startX + ((finishX - startX) / 6) * i, startX + ((finishX - startX) / 6) * (i + 1), startY + levelsGap)
        }
    }

}