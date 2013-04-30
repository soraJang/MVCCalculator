Ext.onReady(function() {
	var panel1 = new Ext.panel.Panel({
		title : 'Hello',
		width : 200
	});

	new Ext.Panel({
		layout : 'border',
		renderTo : 'calcHere',
		title : 'CALCULATOR',
		frame : true,
		items : [ panel1 ]
	});
});
