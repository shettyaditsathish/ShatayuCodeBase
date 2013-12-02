package com.shatayu.util
{
	import com.shatayu.model.Drug;
	import com.shatayu.model.ModelLocatorImp;
	
	public class ShatayuUtility
	{
		public static function getDrugById(drugId:Number):Drug{
			for each(var dr:Drug in ModelLocatorImp.getInstance().drugList){
				if(dr.drugId == drugId){
					return dr;
				}
			}
			
			return null;
		}

	}
}