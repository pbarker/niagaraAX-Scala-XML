niagaraAX-Scala-XML
===================

**Basic script for automating database transfers in Niagara AX using Scala 2.11
  
  If you have ever integrated an old controls system into Niagara AX, you know how excruciatingly monotonous the task can be.
  I wrote a simple scala xml transformation script for our last integration that literally saved me days of work.
  In this instance we were exposing points on an old ALX system and then had to physically go to everypoint in ax and rename it.
  That was too much work for me, so I extracted the points folder via .bog file, converted that to xml and then wrote this script 
  to re-address all the points per box by increments of 100
  
  feel free to email me if you have questions
