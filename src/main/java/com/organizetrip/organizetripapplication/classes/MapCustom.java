/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.organizetrip.organizetripapplication.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;

public class MapCustom extends JXMapViewer {
    // private String zoneName;
    private double latitud;
    private double longitud;
    private int zoom;
    private final Image pinImg;

    public MapCustom() {
        this.latitud = 11.233149;
        this.longitud = -74.186999;
        this.zoom = 5;
        this.pinImg = new ImageIcon(getClass().getResource("/assets/images/pin.png")).getImage();
    }

    public void init() {
        this.changeMapType(MapType.OPEN_STREET);
        setAddressLocation(new GeoPosition(this.latitud, this.longitud));
        setZoom(this.zoom);
        // Move map with mouse
        MouseInputListener mm = new PanMouseInputListener(this);
        addMouseListener(mm);
        addMouseMotionListener(mm);
        // Zoom
        addMouseWheelListener(new ZoomMouseWheelListenerCenter(this));
    }

    // Rounded Map
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw pin
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = (getWidth() / 2) - (this.pinImg.getWidth(null) / 2);
        int y = (getHeight() / 2) - (this.pinImg.getHeight(null) / 2);
        g2.drawImage(this.pinImg, x, y, null);
        // Border of map
        Area area = new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        area.subtract(new Area(new RoundRectangle2D.Double(5, 5, getWidth() - 10, getHeight() - 10, 20, 20)));
        g2.setColor(new Color(24, 24, 24));
        g2.fill(area);
    }
    
    public void changeMapType(MapType type) {
        switch (type) {
            case OPEN_STREET:
                setTileFactory(new DefaultTileFactory(new OSMTileFactoryInfo("", "https://tile.openstreetmap.org")));
                break;
            case VIRTUAL_EARTH:
                setTileFactory(new DefaultTileFactory(new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP)));
                break;
            case HYBRID:
                setTileFactory(new DefaultTileFactory(new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.HYBRID)));
                break;
            case SATELLITE:
                setTileFactory(new DefaultTileFactory(new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.SATELLITE)));
                break;
        }
    }

    public void resetMap() {
        setAddressLocation(new GeoPosition(this.latitud, this.longitud));
        setZoom(this.zoom);
        repaint();
    }
    
}
