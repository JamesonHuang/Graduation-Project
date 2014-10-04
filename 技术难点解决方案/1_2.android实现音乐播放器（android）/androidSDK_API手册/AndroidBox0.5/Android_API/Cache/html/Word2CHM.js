// Word2CHM.js

var bDisableAll = false;
var bDisableSearch = false;

//  ---------------------------------------

function jsMain() {
    if (!bDisableAll) {
        doSearch();
    }
}

function doSearch() {
    if (!bDisableSearch) {
        getSearchKeyword();
    }
}

function getSearchKeyword() {
    var oRecord = function (keyword) {
        this.count = 0;
        this.keyword = keyword;
        this.oNodes = [];
        this.add = function (oNode) {
            this.count++;
            this.oNodes.push(oNode);
        }
    }

    var oRecords = [];
    oRecords.pushRecord = function (keyword) {
        this.push(new oRecord(keyword));
        this[keyword] = this[this.length - 1];
    }

    var bgColor;
    if (window.navigator.userAgent.indexOf("Windows NT 6") == -1) {
        bgColor = "#0a246a";
    }
    else {
        bgColor = "#3399ff";
    }

    var oFontNodes;
    oFontNodes = document.getElementsByTagName("FONT");
    for (var i = 0; i < oFontNodes.length; i++) {
        if (oFontNodes[i].style.backgroundColor == bgColor) {
            var str = "$" + oFontNodes[i].outerText;
            oRecords[str] || oRecords.pushRecord(str);
            oRecords[str].add(oFontNodes[i]);
        }
    }
    oFontNodes.l
    if (oRecords.length == 1) {
        var oNodes = oRecords[0].oNodes;
        renderSearchKeyword(oNodes);
        locateSearchKeyword(oNodes[0]);
    }
}

function renderSearchKeyword(oNodes) {
    for (var i = 0; i < oNodes.length; i++) {
        var j = (i == oNodes.length - 1 ? 0 : i + 1);
        var oNode = oNodes[i];
        var oAnchor = document.createElement("a");

        oAnchor.id = "sbm" + (j).toString();
        oAnchor.nextNode = oNodes[j];
        oAnchor.onmouseover = function () {
            this.style.cursor = "pointer";
        }
        oAnchor.onclick = function () {
            locateSearchKeyword(this.nextNode);
        }

        while (oNode.firstChild) {
            oAnchor.appendChild(oNode.firstChild);
        }
        oNode.appendChild(oAnchor);
        oNode.style.backgroundColor = "#ff8000";
        oNode.style.color = "#ffff00";
    }
}

function locateSearchKeyword(oNode) {
    var toggleColor = function (oNode) {
        return function () {
            var temp;
            with (oNode.style) {
                temp = color;
                color = backgroundColor;
                backgroundColor = temp;
            }
        }
    }
    var nTimerID = setInterval(toggleColor(oNode), 250);

    var stopToggle = function () {
        clearInterval(nTimerID);
    }
    setTimeout(stopToggle, 1000);

    location = "#" + oNode.firstChild.id;
}
