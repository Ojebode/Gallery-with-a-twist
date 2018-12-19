package com.example.vikky;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class VikzGallery extends Activity {
	
	MediaPlayer ourSong;
	private ImageView iv;
    private Button next, previous;
    
    private int currentImage = 0;
    int[] images = { R.drawable.a, R.drawable.b, R.drawable.bb, R.drawable.c, R.drawable.cc, R.drawable.pp, R.drawable.d, R.drawable.dd, R.drawable.e, R.drawable.ee, R.drawable.ff,
    		         R.drawable.jh, R.drawable.gh, R.drawable.h, R.drawable.hh, R.drawable.hi, R.drawable.i, R.drawable.ii, R.drawable.img, R.drawable.j, R.drawable.ju, R.drawable.jv, R.drawable.k,
    		         R.drawable.l, R.drawable.ki, R.drawable.ll, R.drawable.lo, R.drawable.kp, R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.kv, R.drawable.oo, R.drawable.p,
    		         R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.dc, R.drawable.ss, R.drawable.t, R.drawable.tt, R.drawable.u, R.drawable.uu, R.drawable.v, R.drawable.nn,  
    		         R.drawable.vv, R.drawable.vx, R.drawable.w, R.drawable.x,R.drawable.xx, R.drawable.xa, R.drawable.y, R.drawable.yy, R.drawable.z, R.drawable.va, R.drawable.vb, R.drawable.za,
    		         R.drawable.zb, R.drawable.vks, R.drawable.zc, R.drawable.zd, R.drawable.ze, R.drawable.zm, R.drawable.zn, };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vikz_gallery);
		
		iv=(ImageView)findViewById(R.id.imageView1);
		next=(Button)findViewById(R.id.button2);
		previous=(Button)findViewById(R.id.button1);
		ourSong = MediaPlayer.create(VikzGallery.this, R.raw.trueluv);
		ourSong.setLooping(true);
	    ourSong.start();

	        
		
	next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				   //Increase Counter to move to next Image
	            currentImage++;
	            currentImage = currentImage % images.length;

	            iv.setImageResource(images[currentImage]);
	            Toast.makeText(VikzGallery.this, "Queen of my heart", Toast.LENGTH_LONG).show();
			}
		});
		previous.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    //Increase Counter to move to next Image
	            currentImage--;
	            currentImage = (currentImage + images.length) % images.length;

	            iv.setImageResource(images[currentImage]);
	            Toast.makeText(VikzGallery.this, "Love of my life", Toast.LENGTH_LONG).show();

			}
		});
	}
	
	protected void onPause() {
		super.onPause();
		ourSong.release();
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vikz_gallery, menu);
		return true;
	}

}
