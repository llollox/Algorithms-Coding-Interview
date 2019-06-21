package previmedical.it.leetcode.crack

import org.junit.Assert
import org.junit.Test
import previmedical.it.leetcode.problems.crack.dynamic.RobotIntoGrid
import previmedical.it.leetcode.problems.crack.dynamic.TripleSteps

class DynamicTests {


    @Test
    fun tripleStepsRecursiveTest() {

        val tripleSteps = TripleSteps()
        Assert.assertEquals(7, tripleSteps.tripleStepRecursive(4))
        Assert.assertEquals(274, tripleSteps.tripleStepRecursive(10))
        Assert.assertEquals(2555757, tripleSteps.tripleStepRecursive(25))
        Assert.assertEquals(1132436852, tripleSteps.tripleStepRecursive(35))


        Assert.assertEquals(7, tripleSteps.tripleStepMemoization(4))
        Assert.assertEquals(274, tripleSteps.tripleStepMemoization(10))
        Assert.assertEquals(2555757, tripleSteps.tripleStepMemoization(25))
        Assert.assertEquals(1132436852, tripleSteps.tripleStepMemoization(35))


        Assert.assertEquals(7, tripleSteps.tripleStepDynamicProgramming(4))
        Assert.assertEquals(274, tripleSteps.tripleStepDynamicProgramming(10))
        Assert.assertEquals(2555757, tripleSteps.tripleStepDynamicProgramming(25))
        Assert.assertEquals(1132436852, tripleSteps.tripleStepDynamicProgramming(35))

    }


    @Test
    fun robotInGridTest() {

        val G = arrayOf(
            booleanArrayOf(true, true, false, true),
            booleanArrayOf(false, true, true, false),
            booleanArrayOf(true, false, true, true))

        val robotInGrid = RobotIntoGrid()
        val points = robotInGrid.robotInGrid(G)

        Assert.assertEquals(6, points.size)
        Assert.assertEquals(0, points[0].x)
        Assert.assertEquals(0, points[0].y)

        Assert.assertEquals(3, points[5].x)
        Assert.assertEquals(2, points[5].y)


        val pointsMemoization = robotInGrid.robotIntoGridMemoization(G)

        Assert.assertEquals(6, pointsMemoization.size)
        Assert.assertEquals(0, pointsMemoization[0].x)
        Assert.assertEquals(0, pointsMemoization[0].y)

        Assert.assertEquals(3, pointsMemoization[5].x)
        Assert.assertEquals(2, pointsMemoization[5].y)
    }
}