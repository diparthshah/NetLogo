// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim

import org.nlogo.agent.{ Agent, AgentSet, Patch, Turtle }
import org.nlogo.core.{ AgentKind, I18N, Syntax }
import org.nlogo.nvm.{ ArgumentTypeException, Context, Reporter, RuntimePrimitiveException }

class _anybreedon(breedName: String) extends Reporter {


  override def toString: String = s"${super.toString}:$breedName"

  override def report(context: Context): java.lang.Boolean =
    Boolean.box( 
      report_1(context, args(0).report(context)))

  def report_1(context: Context, agentOrSet: AnyRef): Boolean = {
    //val agentSetBuilder = new AgentSetBuilder(AgentKind.Turtle)
    //println("hey1")
    val breed = world.getBreed(breedName)
    agentOrSet match {
      case turtle: Turtle =>
        if (turtle.id == -1)
          throw new RuntimePrimitiveException(context, this,
            I18N.errors.getN("org.nlogo.$common.thatAgentIsDead", turtle.classDisplayName))
        val itr = turtle.getPatchHere.turtlesHere.iterator
        while (itr.hasNext) {
          val t = itr.next()
          if (t.getBreed eq breed)
            true
            //agentSetBuilder.add(t)
        }
      case patch: Patch =>
        val itr = patch.turtlesHere.iterator
        while (itr.hasNext) {
          val t = itr.next()
          if (t.getBreed eq breed)
            true
            //agentSetBuilder.add(t)
        }
      case sourceSet: AgentSet =>
        if (sourceSet.kind == AgentKind.Turtle) {
          val sourceSetItr = sourceSet.iterator
          while (sourceSetItr.hasNext) {
            val turtleItr =
              sourceSetItr.next().asInstanceOf[Turtle].getPatchHere.turtlesHere.iterator
            while (turtleItr.hasNext) { val t = turtleItr.next()
              if (t.getBreed eq breed)
                true
                //agentSetBuilder.add(t)
            }
          }
        } else if (sourceSet.kind == AgentKind.Patch) {
          val sourceSetItr = sourceSet.iterator
          while (sourceSetItr.hasNext) {
            val patchItr = sourceSetItr.next().asInstanceOf[Patch].turtlesHere.iterator
            while (patchItr.hasNext) {
              val t = patchItr.next()
              if (t.getBreed eq breed)
                true
                //agentSetBuilder.add(t)
            }
          }
        }
      case _ =>
        throw new ArgumentTypeException(
          context, this, 0,
          Syntax.TurtleType | Syntax.PatchType |
          Syntax.TurtlesetType | Syntax.PatchsetType,
          agentOrSet)
    }
    false
    //agentSetBuilder.build()
  }

  def report_2(context: Context, sourceSet: AgentSet): Boolean = {
    //val agentSetBuilder = new AgentSetBuilder(AgentKind.Turtle)
    //println("hey2")
    val breed = world.getBreed(breedName)
    if (sourceSet.kind == AgentKind.Turtle) {
      val sourceSetItr = sourceSet.iterator
      while (sourceSetItr.hasNext) {
        val turtleItr =
          sourceSetItr.next().asInstanceOf[Turtle].getPatchHere.turtlesHere.iterator
        while (turtleItr.hasNext) {
          val t = turtleItr.next()
          if (t.getBreed eq breed)
            true
            //agentSetBuilder.add(t)
        }
      }
    } else if (sourceSet.kind == AgentKind.Patch) {
      val sourceSetItr = sourceSet.iterator
      while (sourceSetItr.hasNext) {
        val patchItr = sourceSetItr.next().asInstanceOf[Patch].turtlesHere.iterator
        while (patchItr.hasNext) {
          val t = patchItr.next()
          if (t.getBreed eq breed)
            true
            //agentSetBuilder.add(t)
        }
      }
    } else {
      throw new ArgumentTypeException(
        context, this, 0,
        Syntax.TurtleType | Syntax.PatchType |
        Syntax.TurtlesetType | Syntax.PatchsetType,
        sourceSet)
    }
    false
    //agentSetBuilder.build()
  }

  def report_3(context: Context, agent: Agent): Boolean = {
    //val agentSetBuilder = new AgentSetBuilder(AgentKind.Turtle)
    //println("hey3")
    val breed = world.getBreed(breedName)
    agent match {
      case turtle: Turtle =>
        if (turtle.id == -1)
          throw new RuntimePrimitiveException(context, this,
            I18N.errors.getN("org.nlogo.$common.thatAgentIsDead", turtle.classDisplayName))
        val itr = turtle.getPatchHere.turtlesHere.iterator
        while (itr.hasNext) {
          val t = itr.next()
          if (t.getBreed eq breed)
            true
            //agentSetBuilder.add(t)
        }
      case patch: Patch =>
        val itr = patch.turtlesHere.iterator
        while (itr.hasNext) {
          val t = itr.next()
          if (t.getBreed eq breed)
            true
            //agentSetBuilder.add(t)
        }
      case _ =>
        throw new ArgumentTypeException(
          context, this, 0,
          Syntax.TurtleType | Syntax.PatchType |
          Syntax.TurtlesetType | Syntax.PatchsetType,
          agent)
    }
    false
    //agentSetBuilder.build()
  }

  def report_4(context: Context, turtle: Turtle): Boolean = {
    //val agentSetBuilder = new AgentSetBuilder(AgentKind.Turtle)
    //println("hey4")
    val breed = world.getBreed(breedName)
    if (turtle.id == -1)
      throw new RuntimePrimitiveException(context, this,
        I18N.errors.getN("org.nlogo.$common.thatAgentIsDead", turtle.classDisplayName))
    val itr = turtle.getPatchHere.turtlesHere.iterator
    while (itr.hasNext) {
      val t = itr.next()
      if (t.getBreed eq breed)
        true
        //agentSetBuilder.add(t)
    }
    false
    //agentSetBuilder.build()
  }

  def report_5(context: Context, patch: Patch): Boolean = {
    //val agentSetBuilder = new AgentSetBuilder(AgentKind.Turtle)
    //println("hey5")
    val breed = world.getBreed(breedName)
    val itr = patch.turtlesHere.iterator
    while (itr.hasNext) {
      val t = itr.next()
      if (t.getBreed eq breed)
        true
        //agentSetBuilder.add(t)
    }
    false
    //agentSetBuilder.build()
  }
}
