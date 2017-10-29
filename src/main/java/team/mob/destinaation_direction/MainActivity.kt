package team.mob.destinaation_direction

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val handler=Handler()
    var xy:DoubleArray= doubleArrayOf() // 座標用？

//    val runnable=object : Runnable{
//        // 現在の座標,向きと目的地の座標から矢印の向くべき角度を得、angleに指定する
//        var angle:Float=
//        override fun run() {
//            pointArrow(angle)
//            handler.postDelayed(this,50)
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    pointArrow(25.toFloat())
//        handler.post(runnable)
    }



    fun pointArrow(angle:Float){
        val arrow :AppCompatImageView =findViewById(R.id.arrow)
        val buf:Bitmap=BitmapFactory.decodeResource(resources,R.drawable.arrow)
        val imageWidth:Int=buf.width
        val imageHeight:Int=buf.height
        val matrix:Matrix= Matrix()
        matrix.setRotate(angle,imageWidth.toFloat(),imageHeight.toFloat())
        val outBuf:Bitmap=Bitmap.createBitmap(buf,0,0,imageWidth,imageHeight,matrix,true)
        arrow.setImageBitmap(outBuf)
    }
    fun changeMap(view: View){
//        handler.removeCallbacks(runnable)
        val intent = Intent(this , MapsActivity::class.java)
        startActivity(intent)
    }
}
