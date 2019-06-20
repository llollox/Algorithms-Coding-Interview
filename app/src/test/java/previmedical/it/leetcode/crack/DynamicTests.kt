package previmedical.it.leetcode.crack

import org.junit.Assert
import org.junit.Test
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
}