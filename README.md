SimpleHUD
=========

SimpleHUD is a easy-to-use yet beautiful HUD for android.

![截图](https://raw.githubusercontent.com/wangvsa/SimpleHUD/master/screenshots/screenshot.png)

## Installation

1. Clone or download SimpleHUD if you haven't yet.
2. Import SimpleHUD project.
3. Add SimpleHUD as a dependency to your existing project and you're good to go.

## Usage

(See sample project in /SimpleHUDDemo)

The HUD is created as singleton so you can just use a static method like `showSuccessMessage()` to show a HUD.
If there's a existing HUD, it will be dismissed and show the new one.

### Showing the loading HUD

``java
SimpleHUD.showLoadingMessage(this, "loading data, please wait...", SimpleHUD.TYPE_BLOCK);
``

after your task is finished, call `dismiss()` to dismiss it.
``java
SimpleHUD.dismiss();
``

### Showing the message HUD

The next three HUD are the same except the icon. It will dismiss itself after two seconds so no need to to invoke `dimiss()` explicitly.

``java
SimpleHUD.showInfoMessage(this, "This is a info message.");
SimpleHUD.showErrorMessage(this, "This ia a error message.");
SimpleHUD.showSuccessMessage(this, "This ia a success message.");
```
