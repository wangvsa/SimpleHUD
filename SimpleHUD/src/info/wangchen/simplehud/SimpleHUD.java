package info.wangchen.simplehud;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import info.wangchen.simplehud.R;

public class SimpleHUD {
	
	private static SimpleHUDDialog dialog;
	
	public static final int TYPE_BLOCK = 0;
	public static final int TYPE_NONBLOCK = 1;

	public static void showLoadingMessage(Context context, String msg, int blocktype) {
		dismiss();
		setDialog(context, msg, R.drawable.simplehud_spinner, TYPE_BLOCK);
		dialog.show();
	}
	
	public static void showErrorMessage(Context context, String msg) {
		dismiss();
		setDialog(context, msg, R.drawable.simplehud_error, TYPE_BLOCK);
		dialog.show();
		dismissAfter2s();
	}

	public static void showSuccessMessage(Context context, String msg) {
		dismiss();
		setDialog(context, msg, R.drawable.simplehud_success, TYPE_BLOCK);
		dialog.show();
		dismissAfter2s();
	}
	
	public static void showInfoMessage(Context context, String msg) {
		dismiss();
		setDialog(context, msg, R.drawable.simplehud_info, TYPE_BLOCK);
		dialog.show();
		dismissAfter2s();
	}
	

	
	private static void setDialog(Context ctx, String msg, int resId, int blocktype) {
		//if(dialog==null)
		dialog = SimpleHUDDialog.createDialog(ctx);
		dialog.setMessage(msg);
		dialog.setImage(ctx, resId);

		if(blocktype==TYPE_BLOCK)
			dialog.setCanceledOnTouchOutside(false);
		else
			dialog.setCanceledOnTouchOutside(true);
	}

	public static void dismiss() {
		if(dialog!=null && dialog.isShowing()) {
			dialog.dismiss();
		}
	}




	/**
	 * 计时关闭对话框
	 * 
	 */
	private static void dismissAfter2s() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					handler.sendEmptyMessage(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	

	private static Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if(msg.what==0)
				dismiss();
		};
	};
	

}
