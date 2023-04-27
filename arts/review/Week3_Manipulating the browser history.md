# Manipulating the browser history
# 操控浏览器历史记录

    The DOM window object provides access to the browser's history through the history object.
    通过窗口对象 DOM 可以访问浏览器历史记录。
    It exposes useful methods and properties that let you move back and forth through the user's history,
    它公开了非常有用的方法和属性，使你可以在用户浏览器的历史记录中任意的向前、向后移动。
    as well as -- starting with HTML5 -- manipulate the contents of the history stack.
    从HTML5开始，你也可以操作用户浏览器历史堆栈的内容。
    
### Traveling through history 
    Moving backward and forward through the user's history is done using the back(), forward(), and go() methods.   
    在用户浏览器中前后浏览历史记录一般使用back(),forward()和go()的方法。
#### To move backward through history, just do:
#### 返回操作，可以简单使用：
    window.history.back();
    This will act exactly like the user clicked on the Back button in their browser toolbar.
    这将要执行的操作就像用户在他的浏览的导航栏里点击返回按钮一样。   
    Similarly, you can move forward (as if the user clicked the Forward button), like this:
    同样的你可以向前操作（好像用户点击了浏览器向前的按钮），就像这样：
    window.history.forward();
#### Moving to a specific point in history
#### 移动到一个指定的历史记录点。
    You can use the go() method to load a specific page from session history, 
    你可以使用go()方法从历史会话中来加载一个指定的页面，
    identified by its relative position to the current page 
    该页面通过与当前页面的相对位置进行标识。
    (with the current page being, of course, relative index 0).    
    当前页面的索引为0。
    window.history.go(-1); 相当于 back()
    window.history.go(1);  相当于 forward()
    Similarly, you can move forward 2 pages by passing 2, and so forth.
    同样的，你可以通过使用forward(2)向前移动2页.
    You can determine the number of pages in the history stack by looking at the value of the length property:
    你可以通过查看length属性的值来获得历史记录中页面的数量。
    var numberOfEntries = window.history.length;
### Adding and modifying history entries
### 添加和修改历史记录
    HTML5 introduced the history.pushState() and history.replaceState() methods, 
    HTML5 介绍了history.pushState()和history.replaceState()方法，
    which allow you to add and modify history entries, respectively. 
    允许你独自的添加和修改历史记录。
    These methods work in conjunction with the window.onpopstate event.
    这些方法与window.onpopstate一起工作。
    
    Using history.pushState() changes the referrer that gets used in the HTTP header for XMLHttpRequest objects created after you change the state. 
    The referrer will be the URL of the document whose window is this at the time of creation of the XMLHttpRequest object.

    Example of pushState() method
    Suppose http://mozilla.org/foo.html executes the following JavaScript:
    
    var stateObj = { foo: "bar" };
    history.pushState(stateObj, "page 2", "bar.html");
    This will cause the URL bar to display http://mozilla.org/bar.html, but won't cause the browser to load bar.html or even check that bar.html exists.
    
    Suppose now that the user navigates to http://google.com, then clicks the Back button. At this point, the URL bar will display http://mozilla.org/bar.html, and the page will get will not get a popstate event whose state object contains a copy of stateObj if you read the history.state you will get the stateObj. popstate event won't be fired because the page has been reloaded. The page itself will look like bar.html.
    
    If we click Back again, the URL will change to http://mozilla.org/foo.html, and the document will get a popstate event, this time with a null state object. Here too, going back doesn't change the document's contents from what they were in the previous step, although the document might update its contents manually upon receiving the popstate event.
    
    The pushState() method
    pushState() takes three parameters: a state object, a title (which is currently ignored), and (optionally) a URL. Let's examine each of these three parameters in more detail:
    
    state object — The state object is a JavaScript object which is associated with the new history entry created by pushState(). Whenever the user navigates to the new state, a popstate event is fired, and the state property of the event contains a copy of the history entry's state object.
    
    The state object can be anything that can be serialized. Because Firefox saves state objects to the user's disk so they can be restored after the user restarts the browser, we impose a size limit of 640k characters on the serialized representation of a state object. If you pass a state object whose serialized representation is larger than this to pushState(), the method will throw an exception. If you need more space than this, you're encouraged to use sessionStorage and/or localStorage.
    
    title — Firefox currently ignores this parameter, although it may use it in the future. Passing the empty string here should be safe against future changes to the method. Alternatively, you could pass a short title for the state to which you're moving.
    
    URL — The new history entry's URL is given by this parameter. Note that the browser won't attempt to load this URL after a call to pushState(), but it might attempt to load the URL later, for instance after the user restarts the browser. The new URL does not need to be absolute; if it's relative, it's resolved relative to the current URL. The new URL must be of the same origin as the current URL; otherwise, pushState() will throw an exception. This parameter is optional; if it isn't specified, it's set to the document's current URL.
    
    Note: In Gecko 2.0 (Firefox 4 / Thunderbird 3.3 / SeaMonkey 2.1) through Gecko 5.0 (Firefox 5.0 / Thunderbird 5.0 / SeaMonkey 2.2), the passed object is serialized using JSON. Starting in Gecko 6.0 (Firefox 6.0 / Thunderbird 6.0 / SeaMonkey 2.3), the object is serialized using the structured clone algorithm. This allows a wider variety of objects to be safely passed.
    In a sense, calling pushState() is similar to setting window.location = "#foo", in that both will also create and activate another history entry associated with the current document. But pushState() has a few advantages:
    
    The new URL can be any URL in the same origin as the current URL. In contrast, setting window.location keeps you at the same document only if you modify only the hash.
    You don't have to change the URL if you don't want to. In contrast, setting window.location = "#foo"; creates a new history entry only if the current hash isn't #foo.
    You can associate arbitrary data with your new history entry. With the hash-based approach, you need to encode all of the relevant data into a short string.
    If title is subsequently used by browsers, this data can be utilized (independent of, say, the hash).
    Note that pushState() never causes a hashchange event to be fired, even if the new URL differs from the old URL only in its hash.
    
    In a XUL document, it creates the specified XUL element.
    
    In other documents, it creates an element with a null namespace URI.
    
    The replaceState() method
    history.replaceState() operates exactly like history.pushState() except that replaceState() modifies the current history entry instead of creating a new one. Note that this doesn't prevent the creation of a new entry in the global browser history.
    
    replaceState() is particularly useful when you want to update the state object or URL of the current history entry in response to some user action.
    
    Note: In Gecko 2.0 (Firefox 4 / Thunderbird 3.3 / SeaMonkey 2.1) through Gecko 5.0 (Firefox 5.0 / Thunderbird 5.0 / SeaMonkey 2.2), the passed object is serialized using JSON. Starting in Gecko 6.0 (Firefox 6.0 / Thunderbird 6.0 / SeaMonkey 2.3), the object is serialized using the structured clone algorithm. This allows a wider variety of objects to be safely passed.
    Example of replaceState() method
    Suppose http://mozilla.org/foo.html executes the following JavaScript:
    
    var stateObj = { foo: "bar" };
    history.pushState(stateObj, "page 2", "bar.html");
    The explanation of these two lines above can be found at "Example of pushState() method" section. Then suppose http://mozilla.org/bar.html executes the following JavaScript:
    
    history.replaceState(stateObj, "page 3", "bar2.html");
    This will cause the URL bar to display http://mozilla.org/bar2.html, but won't cause the browser to load bar2.html or even check that bar2.html exists.
    
    Suppose now that the user navigates to http://www.microsoft.com, then clicks the Back button. At this point, the URL bar will display http://mozilla.org/bar2.html. If the user now clicks Back again, the URL bar will display http://mozilla.org/foo.html, and totally bypass bar.html.
    
    The popstate event
    A popstate event is dispatched to the window every time the active history entry changes. If the history entry being activated was created by a call to pushState or affected by a call to replaceState, the popstate event's state property contains a copy of the history entry's state object.
    
    See window.onpopstate for sample usage.
    
    Reading the current state
    When your page loads, it might have a non-null state object.  This can happen, for example, if the page sets a state object (using pushState() or replaceState()) and then the user restarts their browser.  When your page reloads, the page will receive an onload event, but no popstate event.  However, if you read the history.state property, you'll get back the state object you would have gotten if a popstate had fired.
    
    You can read the state of the current history entry without waiting for a popstate event using the history.state property like this:
    
    var currentState = history.state;       
[原文](https://developer.mozilla.org/en-US/docs/Web/API/History_API)

   