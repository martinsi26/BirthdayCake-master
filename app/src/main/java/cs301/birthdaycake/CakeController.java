package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener{

    private CakeView cakeView;
    private CakeModel cakeModel;
    public boolean flame = true;
    public boolean pressed = true;

    public CakeController(CakeView _cakeView) {
        cakeView = _cakeView;
        cakeModel = _cakeView.getCakeModel();
    }

    @Override
    public void onClick(View view) {
        if(pressed) {
            cakeModel.lit = false;
            pressed = false;
        } else {
            cakeModel.lit = true;
            pressed = true;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.isChecked()) {
            cakeModel.hasCandles = true;
        } else {
            cakeModel.hasCandles = false;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        cakeModel.numCandles = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
//Check that it was the first tap
        if(motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN) {
            //Get the finger of pen location
             cakeModel.x = motionEvent.getX();
            cakeModel.y = motionEvent.getY();


            return true;
        }
        return false; //In this case we didn't do anything
    }
}
