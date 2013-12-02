/**
 * ©2009 Flexperiments  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 * 
 * http://labs.flexperiments.nl
 */
 
package com.shatayu.view.patientView {
	
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	
	import mx.collections.ArrayCollection;
	import mx.controls.ComboBox;

	/**
	 * This class alters the normal keyboard behavior of a flex combobox.
	 * With a standard combobox, the index after a keyboard input is set to the
	 * first item which starts with the pressed key.
	 * This combobox first looks if a combination of keys is a valid item.
	 * So if you press A, B in a combobox filled with the following items ['aa', 'ab', 'bb'],
	 * the default combobox would select 'bb', this combobox selects 'ab'.
	 * @author Ids
	 * 
	 */
	public class ComboBox extends mx.controls.ComboBox
	{
		private var _input:String = "";
		private var _cancelClose:Boolean = false;
		
		override protected function keyDownHandler(event:KeyboardEvent):void {
			if(!event.altKey 
				&& !event.ctrlKey 
				&& (event.charCode >= 32 
				&& event.charCode <= 126)) {
				
				event.stopPropagation();
				
				if(!dataProvider && (dataProvider is Array || dataProvider is ArrayCollection))
					return;
				
				_input += String.fromCharCode(event.charCode);
				
				// Prevent close after change event (default behavior)
				_cancelClose = true;
				
				// Set the index to -1, so the currently selected field will be included in the search field
				dropdown.selectedIndex = Math.max(-1, dropdown.selectedIndex - 1);
				
				// Find the input string, if not found...
				if(!dropdown.findString(_input)) {
					
					// ...then try again with only the pressed key (default behavior)
					_input = String.fromCharCode(event.charCode);
					dropdown.findString(_input);
				}
				
				return;
			}
			super.keyDownHandler(event);
		}
		
		override public function close(trigger:Event=null):void {
			
			if(!_cancelClose) {
				super.close(trigger);
				// Clear the input string
				_input = "";
			}
			
			_cancelClose = false;
			
		}
		
	}
}