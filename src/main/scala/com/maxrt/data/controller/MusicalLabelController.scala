package com.maxrt.data.controller

import com.maxrt.db.model.MusicalLabel
import com.maxrt.db.dao.MusicalLabelDao
import com.maxrt.console.Printer
import com.maxrt.data.controller.impl.ControllerImpl

class MusicalLabelController extends ControllerImpl[MusicalLabel](new MusicalLabelDao(), new Printer[MusicalLabel])
