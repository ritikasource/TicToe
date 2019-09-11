package com.ritika.agecalc

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.ritika.tictoe.R

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


      /*  buClick().setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }*/
    }
    var cellid=0
     fun buClick(view: View)
    {
        var buSelected: Button= view as Button

        when(buSelected.id)
        {
            R.id.but1->cellid=1
            R.id.but2->cellid=2
            R.id.but3->cellid=3
            R.id.but4->cellid=4
            R.id.but5->cellid=5
            R.id.but6->cellid=6
            R.id.but7->cellid=7
            R.id.but8->cellid=8
            R.id.but9->cellid=9

        }
       // Toast.makeText(this,"Id: "+cellid,Toast.LENGTH_LONG).show()
        Playgame(cellid,buSelected)
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activeplayer=1

fun Playgame(cellid:Int,buSelected:Button) {

    if (activeplayer == 1) {
        buSelected.text = "X"
        buSelected.setBackgroundColor(Color.GREEN)
        player1.add(cellid)
        activeplayer = 2
        AutoPlay()
    } else {

        buSelected.text = "0"
        buSelected.setBackgroundColor(Color.YELLOW)
        player2.add(cellid)
        activeplayer = 1
    }
    buSelected.isEnabled = false
    CheckGame()
}
fun CheckGame()
{
    var winner=-1
    //row1

    if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
    winner=1}
    if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
        winner=2}
    //row2
    if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
        winner=1}
    if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
        winner=2}
    //row3
    if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
        winner=1}
    if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
        winner=2}


    //col1
    if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
        winner=1}
    if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
        winner=2}
    //col2
    if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
        winner=1}
    if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
        winner=2}
    //col3
    if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
        winner=1}
    if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
        winner=2}

if(winner != -1)
{
    if(winner==1)
    {
        Toast.makeText(this,"PLAYER 1 WINS!",Toast.LENGTH_LONG).show()
    }else
    {
        Toast.makeText(this,"PLAYER 2 WINS!",Toast.LENGTH_LONG).show()
    }
}
}
    fun AutoPlay()
    {
        var emptycell=ArrayList<Int>()
for(cellid in 0..9) {
    if (!(player1.contains(cellid) || player2.contains(cellid))) {
        emptycell.add(cellid)
    }
}
        val r=Random()
        val rindex=r.nextInt(emptycell.size-0)+0
        val cellid=emptycell[rindex]
        var buSelected: Button?
        when(cellid)
        {
            1->buSelected=but1
            2->buSelected=but2
            3->buSelected=but3
            4->buSelected=but4
            5->buSelected=but5
            6->buSelected=but6
            7->buSelected=but7
            8->buSelected=but8
            9->buSelected=but9
                    else ->{buSelected=but1
                    }
        }
        Playgame(cellid,buSelected)
    }







    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
