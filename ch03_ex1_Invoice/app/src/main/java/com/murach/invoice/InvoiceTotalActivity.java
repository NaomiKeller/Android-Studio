/*
Invoice Total
Naomi Keller
Last update: 1/28/2019
Find discount depending on subtotal
 */

package com.murach.invoice;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class InvoiceTotalActivity extends Activity
	implements TextView.OnEditorActionListener {
	// Create variables for the widgets
	private EditText subtotalEditText;
	private TextView discountPercentTextView;
	private TextView discountAmountTextView;
	private TextView totalTextView;
	private String subtotalString;
	private SharedPreferences savedValue;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_invoice_total);

		// get references
		subtotalEditText = (EditText) findViewById(R.id.subtotalEditText);
		discountAmountTextView = (TextView) findViewById(R.id.discountAmountTextView);
		discountPercentTextView = (TextView) findViewById(R.id.discountPercentTextView);
		totalTextView = (TextView) findViewById(R.id.totalTextView);

		subtotalEditText.setOnEditorActionListener(this);

		savedValue = getSharedPreferences("SavedVales", MODE_PRIVATE);
	}

	private void calculateAndDisplay() {
		// get subtotal
		subtotalString = subtotalEditText.getText().toString();
		float subtotal;
		if (subtotalString.equals("")) {
			subtotal = 0;
		}
		else {
			subtotal = Float.parseFloat(subtotalString);
		}

		// get discount percent
		float discountPercent = 0;
		if (subtotal >= 200) {
			discountPercent = .2f;
		} else if (subtotal >= 100) {
			discountPercent = .1f;
		} else {
			discountPercent = 0;
		}

		// calculate discount
		float discountAmount = subtotal * discountPercent;
		float total = subtotal - discountAmount;

		// display results
		NumberFormat percent = NumberFormat.getPercentInstance();
		discountPercentTextView.setText(percent.format(discountPercent));

		NumberFormat currency = NumberFormat.getCurrencyInstance();
		discountAmountTextView.setText(currency.format(discountAmount));
		totalTextView.setText(currency.format(total));
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		calculateAndDisplay();

		//hide soft keyboard
		return false;
	}

	@Override
	public void onResume () {
		super.onResume();
		subtotalString = savedValue.getString("subtotalString", "");
		subtotalEditText.setText(subtotalString);
		calculateAndDisplay();
	}

	@Override
	public void onPause (){
		SharedPreferences.Editor editor = savedValue.edit();
		editor.putString("subtotalString", subtotalString);
		editor.commit();

		super.onPause();
	}

}