package com.logging.kafka.producer.kafkaproducer.loggingfilter.log;

import org.apache.commons.io.output.TeeOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class CustomLogHttpResponseWrapper extends HttpServletResponseWrapper{


        private ByteArrayOutputStream baos = new ByteArrayOutputStream();

        private PrintStream ps = new PrintStream(baos);

        public ByteArrayOutputStream getBaos() {
            return baos;
        }

        public CustomLogHttpResponseWrapper(HttpServletResponse response) {
            super(response);
        }


        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new CustomServletOutputStream(new TeeOutputStream(super.getOutputStream(),ps));
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return new PrintWriter(new TeeOutputStream(super.getOutputStream(),ps));
        }
    }

