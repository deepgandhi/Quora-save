package com.quora.save;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.Intent;
import android.webkit.WebView;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.URL;
import android.webkit.*;
import java.util.Date;
import java.io.*;
import org.apache.http.util.ByteArrayBuffer;
import java.lang.Object;
import java.net.*;
import java.net.MalformedURLException;
import android.content.Context;
import android.net.Uri;
import android.app.DownloadManager.Query;
import android.system.*;
import android.view.*;
import android.content.*;
import android.database.Cursor;


public class MainActivity extends Activity 
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		TextView wv=(TextView)findViewById(R.id.wb);
        Button butt=(Button)findViewById(R.id.but);


		Intent intent = getIntent();
		String action = intent.getAction();
		String type = intent.getType();
		if (Intent.ACTION_SEND.equals(action) && type != null)
		{
			if ("text/plain".equals(type))
			{
				String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
				int i=sharedText.length();
				int m=2;
				String j;
				do{
					j = sharedText.substring(m, i);
					;m++;}
				while(!j.startsWith("http"));

			
				int as=j.length() - 26;
				
	CreateFile a= new CreateFile();
	File path=a.CreateFile1();
	
htmethod h=new htmethod(j,this,wv);
File d=new File(path,"hi.txt");

			}

		}

	}
	
public void Click(View v){
	
	
	File path=new File(Environment.getExternalStorageDirectory(),"Quora");
	File b=new File(path,"hi.txt");
	
	StringBuilder text = new StringBuilder();

	try {
		BufferedReader br = new BufferedReader(new FileReader(b));
		String line;

		while ((line = br.readLine()) != null) {
			text.append(line);
			text.append('\n');
		}
		br.close();
	}
	catch (IOException e) {
		//You'll need to add proper error handling here
	}
	
	int i=text.length();
	int j=i*6/10;

	String irg;
	int k=0;
	String[] img=new String[50];
	int imr=0;
	do{
		
	do{j++;
		int end=j+38;
		if(end>=i){
			break;
		}
		irg=text.substring(j,end);
		}
		while(!irg.startsWith("https://qph.ec.quoracdn.net/main-qimg"));
			int last=j+70;
			if(last>i){
				break;
			}
			img[k]=text.substring(j,last);
			k++;
		imr++;
			}
			while(imr<50);
	for(int start=1;start<k;start=start+2)
	{
	DownloadImage d= new DownloadImage(img[start],this);
	
}



		b.delete();
		android.os.Process.killProcess(android.os.Process.myPid());

	
	}
	
	}
	
class CreateFile{

	File CreateFile1(){
		

		File pth= new File(Environment.getExternalStorageDirectory(),"Quora");
		if(pth.exists()==false){
			pth.mkdirs();}
		File f=new File(pth,"hi.txt");
		if(f.exists()==true)
		{f.delete();}
		
	return(pth);
	}}
	
	
	class htmethod {
		Context con;
	htmethod(String u,Context con,TextView t)
	{
		
		DownloadManager.Request request = new DownloadManager.Request(Uri.parse(u));
		
		request.setDescription("Some descrition");
		request.setTitle("some tita");
// in order for this if to run, you must use the android 3.2 to compile your app
	
			request.allowScanningByMediaScanner();
			request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
	
		request.setDestinationInExternalPublicDir("Quora","/hi.txt");

// get download service and enqueue file
		DownloadManager manager = (DownloadManager)con.getSystemService(Context.DOWNLOAD_SERVICE);
		manager.enqueue(request);
	
		
		
	}

		
	}
	
	
	class DownloadImage{
		DownloadImage(String url,Context con){
			
			DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
			request.allowScanningByMediaScanner();
			request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

			request.setDestinationInExternalPublicDir("Quora","/image.jpg");
			
		DownloadManager manager = (DownloadManager)con.getSystemService(Context.DOWNLOAD_SERVICE);
			manager.enqueue(request);
		
			
		
			
			
			
			
		}
	} 
	
	

