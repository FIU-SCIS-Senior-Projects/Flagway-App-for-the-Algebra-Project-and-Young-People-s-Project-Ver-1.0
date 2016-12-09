package com.example.deyabanisakher.flagwayappdemotest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

/**
 * This activity displays an image on the screen.
 * The image has three different regions that can be clicked / touched.
 * When a region is touched, the activity changes the view to show a different
 * image.
 */

public class Level1 extends FragmentActivity
        implements View.OnTouchListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /**
     * Create the view for the activity.
     */

    public static int range = 10;
    private int modeBnumberCounter = 0;
    private boolean disableNumberButton = false;

    public static int score = 0;
    private int tryNumber = 3;

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        ImageView iv = (ImageView) findViewById(R.id.image);
        if (iv != null) {
            iv.setOnTouchListener(this);
        }

        toast("Touch the screen to discover where the regions are.");

        progressBar = (ProgressBar) findViewById(R.id.progressBar4);
        progressBar.setMax(range-4);

        /*-------------------------------
        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < range -4 ) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        /*----------------------------*/

        addListenerOnButton();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * Respond to the user touching the screen.
     * Change images to make things appear and disappear from the screen.
     */

    public boolean onTouch(View v, MotionEvent ev) {
        boolean handledHere = false;

        final int action = ev.getAction();

        final int evX = (int) ev.getX();
        final int evY = (int) ev.getY();
        int nextImage = -1;            // resource id of the next image to display

        // If we cannot find the imageView, return.
        ImageView imageView = (ImageView) v.findViewById(R.id.image);
        if (imageView == null) return false;

        // When the action is Down, see if we should show the "pressed" image for the default image.
        // We do this when the default image is showing. That condition is detectable by looking at the
        // tag of the view. If it is null or contains the resource number of the default image, display the pressed image.
        Integer tagNum = (Integer) imageView.getTag();
        int currentResource = (tagNum == null) ? R.drawable.p2_ship_default : tagNum.intValue();

        // Now that we know the current resource being displayed we can handle the DOWN and UP events.

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (currentResource == R.drawable.level1_colored) {
                    nextImage = R.drawable.level1_pressed_2;
                    handledHere = true;
           /*
           } else if (currentResource != R.drawable.p2_ship_default) {
             nextImage = R.drawable.p2_ship_default;
             handledHere = true;
           */
                } else handledHere = true;
                break;

            case MotionEvent.ACTION_UP:
                // On the UP, we do the click action.
                // The hidden image (image_areas) has three different hotspots on it.
                // The colors are red, blue, and yellow.
                // Use image_areas to determine which region the user touched.
                int touchColor = getHotspotColor(R.id.image_areas, evX, evY);

                // Compare the touchColor to the expected values. Switch to a different image, depending on what color was touched.
                // Note that we use a Color Tool object to test whether the observed color is close enough to the real color to
                // count as a match. We do this because colors on the screen do not match the map exactly because of scaling and
                // varying pixel density.
                ColorTool ct = new ColorTool();
                int tolerance = 60;
                nextImage = R.drawable.level1_colored;
                YellowRuleDialogFragment rule1Dialog = new YellowRuleDialogFragment();
                BlueRuleDialogFragment rule2Dialog = new BlueRuleDialogFragment();
                RedRuleDialogFragment rule3Dialog = new RedRuleDialogFragment();
                ThreeRuleDialogFragment threeRuleDialog = new ThreeRuleDialogFragment();
                ThreeRuleDisplayFragment threeRuleDisplay = new ThreeRuleDisplayFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
/* Debugging
                System.out.println(touchColor + " yellow "  + Color.YELLOW);
                System.out.println(touchColor + " red "  + Color.RED);
                System.out.println(touchColor + " green "  + Color.GREEN);
                System.out.println(touchColor + " blue "  + Color.BLUE);
                System.out.println(touchColor + " white " + Color.WHITE);
                System.out.println("----------------------------------");
*/

                if (ct.closeMatch(Color.RED, touchColor, tolerance, "red")) {
                    rule1Dialog.show(fragmentManager, "dialog");
                } else if (ct.closeMatch(Color.YELLOW, touchColor, tolerance, "yellow")) {
                    rule3Dialog.show(fragmentManager, "dialog");
                } else if (ct.closeMatch(Color.BLUE, touchColor, tolerance, "blue")) {
                    if (BackBone.gameModeA){
                        threeRuleDisplay.show(fragmentManager, "dialog");
                    }else{
                        threeRuleDialog.show(fragmentManager, "dialog");
                    }
                } else if (ct.closeMatch(Color.GREEN, touchColor, tolerance, "green")) {
                    rule2Dialog.show(fragmentManager, "dialog");
                } else if (ct.closeMatch(Color.WHITE, touchColor, tolerance, "white"))
                    nextImage = R.drawable.level1_colored;
                System.out.println("----------------------------------");

                // If the next image is the same as the last image, go back to the default.
                // toast ("Current image: " + currentResource + " next: " + nextImage);
                if (currentResource == nextImage) {
                    nextImage = R.drawable.level1_colored;
                }
                handledHere = true;
                break;

            default:
                handledHere = false;
        } // end switch

        if (handledHere) {

            if (nextImage > 0) {
                imageView.setImageResource(nextImage);
                imageView.setTag(nextImage);
            }
        }
        return handledHere;
    }


    /**
     * Resume the activity.
     */

    @Override
    protected void onResume() {
        super.onResume();
//
//        View v  = findViewById (R.id.wglxy_bar);
//        if (v != null) {
//
//            //anim1.setAnimationListener (new StartActivityAfterAnimation (i));
//            v.startAnimation (anim1);
//        }
    }

    /**
     * Handle a click on the Wglxy views at the bottom.
     *
     */

//    public void onClickWglxy (View v) {
//        Intent viewIntent = new Intent ("android.intent.action.VIEW",
//                Uri.parse("http://double-star.appspot.com/blahti/ds-download.html"));
//        startActivity(viewIntent);
//
//    }


    /**
     */
    // More methods

    /**
     * Get the color from the hotspot image at point x-y.
     */

    public int getHotspotColor(int hotspotId, int x, int y) {
        ImageView img = (ImageView) findViewById(hotspotId);
        if (img == null) {
            Log.d("ImageAreasActivity", "Hot spot image not found");
            return 0;
        } else {
            img.setDrawingCacheEnabled(true);
            Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
            if (hotspots == null) {
                Log.d("ImageAreasActivity", "Hot spot bitmap was not created");
                return 0;
            } else {
                img.setDrawingCacheEnabled(false);
                return hotspots.getPixel(x, y);
            }
        }
    }

    /**
     * Show a string on the screen via Toast.
     *
     * @param msg String
     * @return void
     */

    public void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    } // end toast

    public void callNewActivity2() {
        Intent intent = new Intent(Level1.this, ThreeRuleInput.class);
        Level1.this.startActivity(intent);
    }

    public void callNewAvtivity() {
        Intent intent = new Intent(Level1.this, RuleInput.class);
        Level1.this.startActivity(intent);
        //finish();

    }

    public void updateScore(){

        if(tryNumber == 3){
            score += 3;
        }else if (tryNumber == 2){
            score += 2;
        }else if(tryNumber == 1){
            score += 1;
        }

    }
    public void verifyAnswer(String color, int number) {

        progressBar = (ProgressBar) findViewById(R.id.progressBar4);
        boolean correctAnswer = BackBone.verifyAnswer(number, color.charAt(0));

        System.out.println("***" + correctAnswer + "***" + color.charAt(0));
        if (correctAnswer) {
            progressStatus += 1;
            progressBar.setProgress(progressStatus);
            if(BackBone.gameModeA){
                displayNextNumberModeA(number);
            }else{
                displayNextNumberModeB(number);
            }
            updateScore();
            tryNumber = 3;
        }else{
            toast("Try Again!");
            tryNumber--;
/*
            if(tryNumber == 0){
                showAnswer();
           }*/
        }

    }

    public void displayNextNumberModeA(int currNumber) {

        System.out.println("ModeA update");

        boolean endRange = false;
        System.out.println("range: " +range);
        if(currNumber == range){
            endRange = true;
        }

        int newNum = currNumber +1;


       while (BackBone.redBag.contains(newNum) || BackBone.blueBag.contains(newNum) || BackBone.yellowBag.contains(newNum)){
           newNum++;
       }

        CharSequence nextNumber = String.valueOf(newNum);

        TextView numberCard = (TextView) findViewById(R.id.numberCard);

        if (!endRange) {
            numberCard.setText(nextNumber);
        } else {
            numberCard.setText("Complete");
            numberCard.setTextSize(10);
            disableNumberButton = true;
        }

    }


    public void displayNextNumberModeB(int currNumber){

        System.out.println("ModeB update");
        System.out.println("range: " +range);
        boolean endRange = false;

        Random generator = new Random();
        int rangeMax = range;
        int range =  rangeMax - 2 + 1;
        int randomNum ;

        if(modeBnumberCounter == range-4){
            endRange = true;
        }

        do{
            randomNum =  generator.nextInt(range) + 2;
        }while ((BackBone.redBag.contains(randomNum) || BackBone.blueBag.contains(randomNum) || BackBone.yellowBag.contains(randomNum)) && !endRange);

        //int nextNumber = randomNum;
        modeBnumberCounter++;
        CharSequence nextNumber = String.valueOf(randomNum);
        TextView numberCard = (TextView) findViewById(R.id.numberCard);
        if (!endRange) {
            numberCard.setText(nextNumber);
        } else {
            numberCard.setText("Done");
        }

    }

    public void addListenerOnButton() {

        final RadioGroup radioColorGroup = (RadioGroup) findViewById(R.id.colorSelection);
        final Button level1Button = (Button) findViewById(R.id.level1Button);



        level1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub



                if (radioColorGroup.getCheckedRadioButtonId() != -1) {
                    int selectedId = radioColorGroup.getCheckedRadioButtonId();
                    System.out.println("____" + selectedId);
                    /*RadioButton buttonSelected = (RadioButton) Level1.this.findViewById(selectedId);
                    buttonSelected.getText();
                    String colorSelected = buttonSelected.getText().toString();*/

                    View radioButton = radioColorGroup.findViewById(selectedId);
                    int radioID = radioColorGroup.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) radioColorGroup.getChildAt(radioID);
                    String colorSelected = (String) btn.getText();

                    TextView numberCard = (TextView) findViewById(R.id.numberCard);
                    String numStr = (String) numberCard.getText();

                    System.out.println(numStr);
                    int number = Integer.parseInt(numStr);

                    verifyAnswer(colorSelected, number);

                    if(disableNumberButton){
                        level1Button.setEnabled(false);
                        FinalScoreDialogFragment finalScoreDialogfrgmt = new FinalScoreDialogFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        finalScoreDialogfrgmt.show(fragmentManager, "dialog");
                    }
                }
            }
        });
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Level1 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
} // end class
