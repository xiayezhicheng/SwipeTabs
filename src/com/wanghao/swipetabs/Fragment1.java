package com.wanghao.swipetabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment {
    
    private View layout = null;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        this.layout = inflater.inflate(R.layout.fragment1, null);
        
        Button btnButton = (Button)layout.findViewById(R.id.btn);
        btnButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "µã»÷ÁËÎÒ", 10000).show();
			}
		});
        return this.layout;
    }
    
}
