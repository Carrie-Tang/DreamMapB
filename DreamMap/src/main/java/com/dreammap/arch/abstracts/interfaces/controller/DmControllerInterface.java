package com.dreammap.arch.abstracts.interfaces.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/**
 * Created by Lenovo on 2017/4/22.
 */
public interface DmControllerInterface {
    Object add(@Context HttpServletRequest httpRequest);
    Object del(@Context HttpServletRequest httpRequest);
    Object upd(@Context HttpServletRequest httpRequest);
    Object one(@Context HttpServletRequest httpRequest);
    Object lst(@Context HttpServletRequest httpRequest);
}
