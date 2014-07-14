SimpleHUD
=========

SimpleHUD is an easy-to-use yet beautiful HUD for android.

![截图](https://raw.githubusercontent.com/wangvsa/SimpleHUD/master/screenshots/screenshot.png)

## Installation

1. Clone or download SimpleHUD if you haven't yet.
2. Import SimpleHUD project.
3. Add SimpleHUD as a dependency to your existing project and you're good to go.

## Usage

(See sample project in /SimpleHUDDemo)

The HUD is created as singleton so you can just use a static method like `showSuccessMessage()` to show a HUD.
If there's an existing HUD, it will be dismissed and show the new one.

### Showing the loading dialog

```java
SimpleHUD.showLoadingMessage(this, "loading data, please wait...", SimpleHUD.TYPE_BLOCK);
```

Note the third parameter, if you set it to TYPE_NONBLOCK then the users can touch outside to cancel the HUD.

When your operation is completed, call `dismiss()` method to dismiss it.
```java
SimpleHUD.dismiss();
```

### Showing the message dialog

The next three HUD are the same except the icon.
It will dismiss itself after two seconds so no need to to invoke `dimiss()` explicitly.

```java
SimpleHUD.showInfoMessage(this, "This is a info message.");
SimpleHUD.showErrorMessage(this, "This ia an error message.");
SimpleHUD.showSuccessMessage(this, "This ia a success message.");
```

## Customization

### Change the icon

There are three icons in drawable folder, you can replace them using your own icons with the same name.
