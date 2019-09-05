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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
    protected fun buClick(view: View)
    {
        val buSelected: Button= view as Button
        var cellid=0
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
    } else {

        buSelected.text = "0"
        buSelected.setBackgroundColor(Color.YELLOW)
        player1.add(cellid)
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
