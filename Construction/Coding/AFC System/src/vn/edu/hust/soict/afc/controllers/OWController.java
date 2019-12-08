/**
 * @author duypv
 * @date Oct 23, 2019
 * @project afc_application
 * @lecturer Nguyen Thi Thu Trang
 * @class 111589
 *
 * @description The Automated Fare Controller sumulation program
 */
package vn.edu.hust.soict.afc.controllers;

import vn.edu.hust.soict.afc.common.AppState;
import vn.edu.hust.soict.afc.common.DataResponse;
import vn.edu.hust.soict.afc.services.IItemService;
import vn.edu.hust.soict.afc.services.OWTicketServiceImpl;
import vn.edu.hust.soict.afc.utils.IFareCalculator;

/**
 * One-way ticket controller
 * @author duypv
 *
 */
public class OWController implements ItemController {
	private IItemService oWTicketService;

	public OWController(IFareCalculator fareCalculator) {
		oWTicketService = new OWTicketServiceImpl(fareCalculator);
	}

	@Override
	public DataResponse process(AppState appState) {
		if (appState.isActCheckIn()) {
			return oWTicketService.checkIn(appState.getItemBarcode(), appState.getSelectedStation());
		} else {
			return oWTicketService.checkOut(appState.getItemBarcode(), appState.getSelectedStation());
		}
	}
}
