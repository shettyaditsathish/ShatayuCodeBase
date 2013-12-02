package com.shatayu.util
{
	import flash.filesystem.File;
	
	public class BootStrap
	{
		private static var _instance:BootStrap = null;
		public var expXML:XML;
		
		public function BootStrap()
		{
			initialize();
		}
		
		public static function getInstance():BootStrap{
			if(!_instance){
				_instance = new BootStrap();
			}
			return _instance;
		}
		
		private function initialize():void{
			var expStr:String = "<expRt/>";
			try{
				expStr = FileUtility.readFile(File.applicationStorageDirectory.nativePath + "/"+"exp.xml");
			}catch(e:Error){
				
			}
			
			expXML = new XML(expStr);
		}
		
		

	}
}