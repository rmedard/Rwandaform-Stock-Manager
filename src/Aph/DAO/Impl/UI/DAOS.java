/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl.UI;

import Aph.DAO.BlockDélivréDAO;
import Aph.DAO.CiterneDAO;
import Aph.DAO.DensitéDAO;
import Aph.DAO.Impl.CiterneDAOImpl;
import Aph.DAO.Impl.MatièrePremièreDAOImpl;
import Aph.DAO.Impl.BlockDAOImpl;
import Aph.DAO.Impl.BlockDélivréDAOImpl;
import Aph.DAO.Impl.DensitéDAOImpl;
import Aph.DAO.Impl.ProductionDAOImpl;
import Aph.DAO.Impl.ProduitDAOImpl;
import Aph.DAO.Impl.ProduitDélivréDAOImpl;
import Aph.DAO.Impl.TechnicienBlockDAOImpl;
import Aph.DAO.Impl.TotalProduitDélivréDAOImpl;
import Aph.DAO.Impl.UserDAOImpl;
import Aph.DAO.MatièrePremièreDAO;
import Aph.DAO.ProductionDAO;
import Aph.DAO.ProduitDAO;
import Aph.DAO.ProduitDélivréDAO;
import Aph.DAO.ProduitSemiFiniDAO;
import Aph.DAO.TechnicienDAO;
import Aph.DAO.TotalProduitDélivréDAO;
import Aph.DAO.UserDAO;

/**
 *
 * @author Medard
 */
public final class DAOS {

    private CiterneDAO citerneDAO;
    private MatièrePremièreDAO matièrePremièreDAO;
    private ProduitSemiFiniDAO produitSemiFiniDAO;
    private TechnicienDAO technicienDAO;
    private UserDAO userDAO;
    private DensitéDAO densitéDAO;
    private ProduitDélivréDAO produitDélivréDAO;
    private ProduitDAO produitDAO;
    private ProductionDAO productionDAO;
    private TotalProduitDélivréDAO totalProduitDélivréDAO;
    private BlockDélivréDAO blockDélivréDAO;

    public DAOS() {
        setCiterneDAO(new CiterneDAOImpl());
        setMatièrePremièreDAO(new MatièrePremièreDAOImpl());
        setProduitSemiFiniDAO(new BlockDAOImpl());
        setTechnicienDAO(new TechnicienBlockDAOImpl());
        setUserDAO(new UserDAOImpl());
        setDensitéDAO(new DensitéDAOImpl());
        setProduitDélivréDAO(new ProduitDélivréDAOImpl());
        setProduitDAO(new ProduitDAOImpl());
        setProductionDAO(new ProductionDAOImpl());
        setTotalProduitDélivréDAO(new TotalProduitDélivréDAOImpl());
        setBlockDélivréDAO(new BlockDélivréDAOImpl());
    }

    public CiterneDAO getCiterneDAO() {
        return citerneDAO;
    }

    public void setCiterneDAO(CiterneDAO citerneDAO) {
        this.citerneDAO = citerneDAO;
    }

    public MatièrePremièreDAO getMatièrePremièreDAO() {
        return matièrePremièreDAO;
    }

    public void setMatièrePremièreDAO(MatièrePremièreDAO matièrePremièreDAO) {
        this.matièrePremièreDAO = matièrePremièreDAO;
    }

    public ProduitSemiFiniDAO getProduitSemiFiniDAO() {
        return produitSemiFiniDAO;
    }

    public void setProduitSemiFiniDAO(ProduitSemiFiniDAO produitSemiFiniDAO) {
        this.produitSemiFiniDAO = produitSemiFiniDAO;
    }

    public TechnicienDAO getTechnicienDAO() {
        return technicienDAO;
    }

    public void setTechnicienDAO(TechnicienDAO technicienDAO) {
        this.technicienDAO = technicienDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setDensitéDAO(DensitéDAO densitéDAO) {
        this.densitéDAO = densitéDAO;
    }

    public DensitéDAO getDensitéDAO() {
        return densitéDAO;
    }

    public ProduitDélivréDAO getProduitDélivréDAO() {
        return produitDélivréDAO;
    }

    public void setProduitDélivréDAO(ProduitDélivréDAO produitDélivréDAO) {
        this.produitDélivréDAO = produitDélivréDAO;
    }

    public ProduitDAO getProduitDAO() {
        return produitDAO;
    }

    public void setProduitDAO(ProduitDAO produitDAO) {
        this.produitDAO = produitDAO;
    }

    public ProductionDAO getProductionDAO() {
        return productionDAO;
    }

    public void setProductionDAO(ProductionDAO productionDAO) {
        this.productionDAO = productionDAO;
    }

    public TotalProduitDélivréDAO getTotalProduitDélivréDAO() {
        return totalProduitDélivréDAO;
    }

    public void setTotalProduitDélivréDAO(TotalProduitDélivréDAO totalProduitDélivréDAO) {
        this.totalProduitDélivréDAO = totalProduitDélivréDAO;
    }

    public BlockDélivréDAO getBlockDélivréDAO() {
        return blockDélivréDAO;
    }

    public void setBlockDélivréDAO(BlockDélivréDAO blockDélivréDAO) {
        this.blockDélivréDAO = blockDélivréDAO;
    }
    
}
