using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
using SoapService.EntityClasses;

namespace SoapService.Contexts
{
    public class ServiceDbContext : DbContext
    {
        public ServiceDbContext(string connectionString) : base(connectionString)
        {
            Configuration.AutoDetectChangesEnabled = true;
            Configuration.LazyLoadingEnabled = true;
            Configuration.ProxyCreationEnabled = true;
            Configuration.ValidateOnSaveEnabled = true;
            Database.SetInitializer(new ServiceDbInitializer());
        }
        public DbSet<Flat> Flats { get; set; }
        public DbSet<Deal> Deals { get; set; }
        public DbSet<Region> Regions { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Flat>()
            .HasMany(s => s.Deals)
            .WithRequired(s => s.Flat);

            modelBuilder.Entity<Region>()
               .HasMany(s => s.Flats)
               .WithRequired(s => s.Region);
            base.OnModelCreating(modelBuilder);
        }

        protected override void Dispose(bool disposing)
        {
            Configuration.LazyLoadingEnabled = false;
            base.Dispose(disposing);
        }
    }
    public class ServiceDbInitializer : DropCreateDatabaseAlways<ServiceDbContext>
    {
        protected override void Seed(ServiceDbContext context)
        {
            List<Deal> deals = new List<Deal>()
            {
                new Deal()
                {
                    Date = DateTime.Now,
                    Price = 4500000,
                    Flat = new Flat()
                    {
                        Area = 200,
                        Balcony = true,
                        Region = new Region()
                        {
                            Name = "dsa",
                            Flats = new List<Flat>()
                        }
                        , Rooms = 10 }
                },
                new Deal()
                {
                    Date = new DateTime(2016,10,12),
                    Price = 450000,
                    Flat = new Flat()
                    {
                        Area = 20,
                        Balcony = true,
                        Region = new Region()
                        {
                            Name = "dsa",
                            Flats = new List<Flat>()
                        }
                        , Rooms = 1 }
                },
                new Deal()
                {
                    Date = new DateTime(2016,10,12),
                    Price = 1500000,
                    Flat = new Flat()
                    {
                        Area = 2200,
                        Balcony = false,
                        Region = new Region()
                        {
                            Name = "dsa",
                            Flats = new List<Flat>()
                        }
                        , Rooms = 110 }
                }
            };
            context.Deals.AddRange(deals);

        }
    }

}
