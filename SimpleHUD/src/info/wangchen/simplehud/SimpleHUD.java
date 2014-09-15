package info.wangchen.simplehud;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

public class SimpleHUD {
	
	private static SimpleHUDDialog dialog;
	private static Context context;		
	
	public static void showLoadingMessage(Context context, String msg, boolean cancelable) {
		dismiss();
		setDialog(context, msg, R.drawable.simplehud_spinner, cancelable);
		dialog.show();
	}
	
	public static void showErrorMessage(Context context, String msg) {
		dismiss();
		setDialog(context, msg, R.drawable.simplehud_error, true);
		dialog.show();
		dismissAfter2s();
	}

	public static void showSuccessMessage(Context context, String msg) {
		dismiss();
		setDialog(context, msg, R.drawable.simplehud_success, true);
		dialog.show();
		dismissAfter2s();
	}
	
	public static void showInfoMessage(Context context, String msg) {
		dismiss();
		setDialog(context, msg, R.drawable.simplehud_info, true);
		dialog.show();
		dismissAfter2s();
	}
	

	
	private static void setDialog(Context ctx, String msg, int resId, boolean cancelable) {
		dialog = SimpleHUDDialog.createDialog(ctx);
		dialog.setMessage(msg);
		dialog.setImage(ctx, resId);
		dialog.setCanceledOnTouchOutside(false);
		dialog.setCancelable(cancelable);		// back键是否可dimiss对话框
		
		context = ctx;

	}

	public static void dismiss() {
		if(context instanceof Activity) {
			Activity act = (Activity)context;
			// 如果被绑定的activity已经结束了调用dismiss会出错
			if(act==null || act.isDestroyed()) {
				return;
			}
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
