package com.Epic_ModZz.Magically_Magic.util.handlers;

import com.Epic_ModZz.Magically_Magic.PlayerInfo.PhaseInfo;

public class PhaseHandler implements PhaseInfo{

	 private Boolean Phased = false;
	
	@Override
	public void phase() {
		this.Phased = !Phased;
	}

	@Override
	public void set(Float yes) {
		if(yes == 1) {
			Phased = true;
		}else {
			Phased = false;			
		}
		
	}
	 public boolean get()
	 {
	 return this.Phased;
	 }

	@Override
	public float convertfloat() {
		if(this.Phased) {
			return 1;
		}else {
			return 0;
		}		
	}	
}
