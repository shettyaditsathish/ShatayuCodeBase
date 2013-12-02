package com.shatayu.util
{
	import flash.filesystem.File;
	import flash.filesystem.FileMode;
	import flash.filesystem.FileStream;

	public class FileUtility
	{
		
		public static function readFile(filePath:String):String{
			var sourceFile:File = new File(filePath);
			var fstream:FileStream = new FileStream();
			fstream.open(sourceFile,FileMode.READ);
			var content:String = fstream.readUTFBytes(fstream.bytesAvailable);
			fstream.close();
			return content;
		}
		
		public static function writeFile(content:String,filePath:String):void{
			var destFile:File = new File(filePath);
			var fostream:FileStream = new FileStream();
			fostream.open(destFile,FileMode.WRITE);
			fostream.writeUTFBytes(content);
			fostream.close();
		}
	}
}