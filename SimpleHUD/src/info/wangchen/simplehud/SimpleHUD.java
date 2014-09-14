package info.wangchen.simplehud;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

public class SimpleHUD {
	
	private static SimpleHUDDialog dialog;
	private static Activity activity;		
	
	public static final int TYPE_BLOCK = 0;
	public static final int TYPE_NONBLOCK = 1;

	public static void showLoadingMessage(Activity activity, String msg, int blocktype) {
		dismiss();
		setDialog(activity, msg, R.drawable.simplehud_spinner, TYPE_BLOCK);
		dialog.show();
	}
	
	public static void showErrorMessage(Activity activity, String msg) {
		dismiss();
		setDialog(activity, msg, R.drawable.simplehud_error, TYPE_BLOCK);
		dialog.show();
		dismissAfter2s();
	}

	public static void showSuccessMessage(Activity activity, String msg) {
		dismiss();
		setDialog(activity, msg, R.drawable.simplehud_success, TYPE_BLOCK);
		dialog.show();
		dismissAfter2s();
	}
	
	public static void showInfoMessage(Activity activity, String msg) {
		dismiss();
		setDialog(activity, msg, R.drawable.simplehud_info, TYPE_BLOCK);
		dialog.show();
		dismissAfter2s();
	}
	

	
	private static void setDialog(Activity act, String msg, int resId, int blocktype) {
		dialog = SimpleHUDDialog.createDialog(activity);
		dialog.setMessage(msg);
		dialog.setImage(activity, resId);
		
		activity = act;

		if(blocktype==TYPE_BLOCK)
			dialog.setCanceledOnTouchOutside(false);
		else
			dialog.setCanceledOnTouchOutside(true);
	}

	public static void dismiss() {
		// 如果被绑定的activity已经结束了调用dismiss会出错
		if(activity==null || activity.isDestroyed()) {
			return;
		}
		if(dialog!=null && dialog.isShowing())
			dialog.dismiss();
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
