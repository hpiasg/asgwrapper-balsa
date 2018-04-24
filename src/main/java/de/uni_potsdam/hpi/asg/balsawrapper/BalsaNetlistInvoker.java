package de.uni_potsdam.hpi.asg.balsawrapper;

/*
 * Copyright (C) 2017 - 2018 Norman Kluge
 * 
 * This file is part of ASGwrapper-balsa.
 * 
 * ASGwrapper-balsa is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ASGwrapper-balsa is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with ASGwrapper-balsa.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.uni_potsdam.hpi.asg.common.invoker.ExternalToolsInvoker;
import de.uni_potsdam.hpi.asg.common.invoker.InvokeReturn;

public class BalsaNetlistInvoker extends ExternalToolsInvoker {

    private BalsaNetlistInvoker() {
        super("balsanetlist");
    }

    public static boolean implementComponent(String technology, File outFile, String component, List<String> componentParams) {
        return new BalsaNetlistInvoker().internalImplementComponent(technology, outFile, component, componentParams);
    }

    public static InvokeReturn implementBreeze(String technology, File breezeFile, File outFile) {
        return new BalsaNetlistInvoker().internalImplementBreeze(technology, breezeFile, outFile);
    }

    private boolean internalImplementComponent(String technology, File outFile, String component, List<String> componentParams) {
        List<String> params = new ArrayList<>();
        //@formatter:off
        params.addAll(Arrays.asList(
            "-X", technology, 
            "-o", outFile.getName(), 
            "-t", component
        ));
        //@formatter:on
        for(String str : componentParams) {
            params.add(str.replaceAll("\"", ""));
        }

        addOutputFilesToExport(outFile);

        InvokeReturn ret = run(params, "balsanetlist_" + outFile.getName());
        return errorHandling(ret);
    }

    private InvokeReturn internalImplementBreeze(String technology, File breezeFile, File outFile) {
        String parent = ".";
        String logFileName = "logfile.log";

        List<String> params = new ArrayList<>();
        //@formatter:off
        params.addAll(Arrays.asList(
            "-X", technology, 
            "-o", outFile.getName(), 
            "-L", logFileName,
            "-I", parent,
            breezeFile.getName()
        ));
        //@formatter:on

        addInputFilesToCopy(breezeFile);
        addOutputFilesToExport(outFile);
        addOutputFilesDownloadOnlyStartsWith(logFileName);

        InvokeReturn ret = run(params, "balsanetlist_" + outFile.getName());
        errorHandling(ret);
        return ret;
    }
}